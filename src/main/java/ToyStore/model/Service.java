package ToyStore.model;

import ToyStore.Keys;
import ToyStore.model.items.Item;
import ToyStore.model.products.Tag;
import ToyStore.model.products.Toy;
import ToyStore.model.storages.Storage;
import ToyStore.model.storages.repo.BinDB;
import ToyStore.model.storages.repo.DB;

import java.util.*;

public class Service {
    private Storage<Item> shop;
    private final Storage<Item> prizes;
    private final DB<Storage<Item>> repository;

    public Service() {
        repository = new BinDB<>();
        getShop();
        prizes = new Storage<>();
    }

    private void getShop() {
        shop = repository.load();
        if (shop == null) {
            getNewProducts();
        }
    }

    public void getNewProducts() {
        if(shop == null){
            shop = new Storage<>();
        }

        Random rand = new Random();

        for (int i = 0; i < rand.nextInt(5, 20); i++) {
            String name = "игрушка" + rand.nextInt(1, 30);
            Item item = (Item)shop.search(name);
            if(item != null){
                item.increaseAmount();
            } else {
                List<Tag> tags = new ArrayList<>();
                for(int j = 0; j < Tag.values().length; j++){
                    if(rand.nextInt()%5 == 0 && tags.size() < 3) {
                        tags.add(Tag.values()[j]);
                    }
                }
                Toy toy = new Toy(name, rand.nextInt(1000, 10000) / 100.0D, tags.stream().toArray(Tag[]::new));
                item = new Item(UUID.randomUUID().toString(), toy, rand.nextInt(100), (rand.nextDouble() + 9) / 10.0D);
                shop.add(item);
            }
        }
        repository.save(shop);
    }

    public Map<String, String> getCurrentShopProductItem() {
        return nullCheck(shop.getCurrent());
    }

    public Map<String, String> getNextShopProductItem() {
        return nullCheck(shop.getNext());
    }

    public Map<String, String> getPrevShopProductItem() {
        return nullCheck(shop.getPrevious());
    }

    public Map<String, String> getCurrentPrizeProductItem() {
        return nullCheck(prizes.getCurrent());
    }

    public Map<String, String> getNextPrizeProductItem() {
        return nullCheck(prizes.getNext());
    }

    public Map<String, String> getPrevPrizeProductItem() {
        return nullCheck(prizes.getPrevious());
    }

    public void addToPrizes() {
        Item shopItem = shop.getCurrent();
        if (shopItem == null) {
            return;
        }
        shopItem.decreaseAmount();
        if (shopItem.amount() == 0) {
            shop.remove(shopItem);
        }
        Item prizeItem = prizes.getItem(shopItem.id());
        if (prizeItem != null) {
            prizeItem.increaseAmount();
        } else {
            prizes.add(new Item(shopItem.id(), shopItem.product(), 1, shopItem.getLuck()));
        }
    }

    public void removeFromPrizes() {
        Item prizeItem = prizes.getCurrent();
        if (prizeItem == null) {
            return;
        }
        prizeItem.decreaseAmount();
        if (prizeItem.amount() == 0) {
            prizes.remove(prizeItem);
        }
        Item shopItem = shop.getItem(prizeItem.id());
        if (shopItem != null) {
            shopItem.increaseAmount();
        } else {
            shop.add(new Item(prizeItem.id(), prizeItem.product(), 1, prizeItem.getLuck()));
        }
    }
    public List<Map<String, String>> getPrizesDetail() {
        Map<String, String> map = new HashMap<>();
        map.put(Keys.PRICE_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), prizes.priceAll(false)));
        map.put(Keys.PRIZE_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), prizes.priceAll(true)));
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        list.addAll(prizes.getList());
        return list;
    }
    private Map<String, String> nullCheck(Item item) {
        if (item == null) {
            return null;
        }
        return item.detail();
    }
    public Map<String, String> getAmountInPrizes() {
        Map<String, String> map = new HashMap<>();
        int amount = 0;
        for (Item item : prizes) {
            amount += item.amount();
        }
        map.put(Keys.AMOUNT.getKey(), String.format("%d", amount));
        return map;
    }

    public void buy() {
        prizes.clear();
        repository.save(shop);
    }
}
