package ToyStore.presenter;

import ToyStore.model.Service;

import java.util.List;
import java.util.Map;

public class Presenter {
    private Service service;
    public Presenter() {
        service = new Service();
    }
    public Map<String, String> getCurrentShopProduct() {
        return service.getCurrentShopProductItem();
    }
    public Map<String, String> getNextShopProduct() {
        return service.getNextShopProductItem();
    }
    public Map<String, String> getPreviousShopProduct() {
        return service.getPrevShopProductItem();
    }
    public Map<String, String> getCurrentPrizeProduct() {
        return service.getCurrentPrizeProductItem();
    }
    public Map<String, String> getNextPrizeProduct() {
        return service.getNextPrizeProductItem();
    }
    public Map<String, String> getPreviousPrizeProduct() {
        return service.getPrevPrizeProductItem();
    }
    public Map<String, String> addToPrizes() {
        service.addToPrizes();
        return getCurrentShopProduct();
    }
    public Map<String, String> removeFromPrizes() {
        service.removeFromPrizes();
        return getCurrentShopProduct();
    }
    public List<Map<String, String>> getPrizeDetail() {
        return service.getPrizesDetail();
    }
    public Map<String, String> getAmountInPrizes() {
        return service.getAmountInPrizes();
    }
    public void buy() {
        service.buy();
    }
    public void getNewProducts() {
        service.getNewProducts();
    }
}
