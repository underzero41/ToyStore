package ToyStore.view;

public interface Performing {
    void getCurrentShopPage();
    void getNextShopPage();
    void getPreviousShopPage();
    void getCurrentPrizePage();
    void getNextPrizePage();
    void getPreviousPrizePage();
    void addToPrize();
    void removeFromPrize();
    void goToPrize();
    void goToShop();
    void Quit();
    void buy();
    void getNewProducts();
}
