package csd214.bookstore.pojos;

public class GiftWrap implements SaleableItem{
    @Override
    public double getPrice() {
        return 2.00;
    }
    @Override
    public void sellItem() {
        System.out.println("Gift Wrapping service sold!");
    }
}
