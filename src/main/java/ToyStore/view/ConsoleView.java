package ToyStore.view;

import ToyStore.Keys;
import ToyStore.presenter.Presenter;
import ToyStore.view.pages.Page;
import ToyStore.view.pages.PrizePage;
import ToyStore.view.pages.ShopPage;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View, Performing {
    private boolean isWork;
    private Page currentPage;
    private final Scanner scanner;
    private final ShopPage shopPage;
    private final PrizePage prizePage;
    private final Presenter presenter;
    private final String SHOP = "РОЗЫГРЫШЬ ИГРУШЕК > в магазине";
    private final String PRIZE = "РОЗЫГРЫШЬ ИГРУШЕК > в призах";
    public ConsoleView() {
        scanner = new Scanner(System.in);
        presenter = new Presenter();
        shopPage = new ShopPage(this);
        prizePage = new PrizePage(this);
        currentPage = shopPage;
        isWork = true;
    }
    @Override
    public void start() {
        Dialog(0);
        while (isWork) {
            Dialog(getIntInput() - 1);
        }
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }
    // #endregion

    // #region implements executable
    @Override
    public void getCurrentShopPage() {
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInPrizes());
    }

    @Override
    public void getNextShopPage() {
        printPage(SHOP, presenter.getNextShopProduct());
        printAmount(presenter.getAmountInPrizes());
    }

    @Override
    public void getPreviousShopPage() {
        printPage(SHOP, presenter.getPreviousShopProduct());
        printAmount(presenter.getAmountInPrizes());
    }

    @Override
    public void getCurrentPrizePage() {
        printPage(PRIZE, presenter.getCurrentPrizeProduct());
        printDetail(presenter.getPrizeDetail());
    }

    @Override
    public void getNextPrizePage() {
        printPage(PRIZE, presenter.getNextPrizeProduct());
        printDetail(presenter.getPrizeDetail());
    }

    @Override
    public void getPreviousPrizePage() {
        printPage(PRIZE, presenter.getPreviousPrizeProduct());
        printDetail(presenter.getPrizeDetail());
    }

    @Override
    public void addToPrize() {
        presenter.addToPrizes();
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInPrizes());
    }

    @Override
    public void removeFromPrize() {
        presenter.removeFromPrizes();
        printPage(PRIZE, presenter.getCurrentPrizeProduct());
        printDetail(presenter.getPrizeDetail());
    }

    @Override
    public void goToPrize() {
        currentPage = prizePage;
        printPage(PRIZE, presenter.getCurrentPrizeProduct());
        printDetail(presenter.getPrizeDetail());
    }

    @Override
    public void goToShop() {
        currentPage = shopPage;
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInPrizes());
    }

    @Override
    public void getNewProducts(){
        presenter.getNewProducts();
        printPage(SHOP, presenter.getCurrentShopProduct());
        printAmount(presenter.getAmountInPrizes());
    }


    @Override
    public void buy(){
        presenter.buy();
        printPage(PRIZE, presenter.getCurrentPrizeProduct());
        printDetail(presenter.getPrizeDetail());
    }

    @Override
    public void Quit() {
        isWork = false;
    }

    private void printPage(String titlePage, Map<String, String> dataPage) {
        if (dataPage == null) {
            print(String.format(Templates.PAGE_EMPTY.getTemplate(), titlePage));
            return;
        }
        print(String.format(Templates.PAGE.getTemplate(),
                titlePage,
                dataPage.get(Keys.TOTAL.getKey()),
                dataPage.get(Keys.TAGS.getKey()),
                dataPage.get(Keys.AMOUNT.getKey()),
                dataPage.get(Keys.PRICE.getKey()),
                dataPage.get(Keys.WEIGHT.getKey()),
                dataPage.get(Keys.LUCK.getKey())));
    }

    private void printAmount(Map<String, String> dataAmount) {
        if (dataAmount == null) {
            return;
        }
        print(String.format(Templates.PRIZE_AMOUNT.getTemplate(), dataAmount.get(Keys.AMOUNT.getKey())));
    }
    private void printDetail(List<Map<String, String>> dataResult) {
        if (dataResult == null) {
            return;
        }
        print(Templates.PRIZE_TITLE_ITEM.getTemplate());
        for (int i = 1; i < dataResult.size(); i++) {
            print(String.format(Templates.PRIZE_ITEM.getTemplate(),
                    String.format("%d", (i)),
                    dataResult.get(i).get(Keys.TOTAL.getKey()),
                    dataResult.get(i).get(Keys.AMOUNT.getKey()),
                    dataResult.get(i).get(Keys.PRICE.getKey()),
                    dataResult.get(i).get(Keys.LUCK.getKey()),
                    dataResult.get(i).get(Keys.PRICE_TOTAL.getKey()),
                    dataResult.get(i).get(Keys.PRIZE_TOTAL.getKey())));
        }
        print(String.format(Templates.PRIZE_RESULT.getTemplate(),
                dataResult.get(0).get(Keys.PRICE_TOTAL.getKey()),
                dataResult.get(0).get(Keys.PRIZE_TOTAL.getKey())));
    }
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void Dialog(int number) {
        clearScreen();
        currentPage.execute(number);
        print(currentPage.toString() + "\r\n");
    }

    private int getIntInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("[0-9]+")) {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= shopPage.size()) {
                    return number;
                }
            }
        } while (true);
    }
}
