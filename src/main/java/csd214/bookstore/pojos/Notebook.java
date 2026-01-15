package csd214.bookstore.pojos;

public class Notebook extends Stationery{

    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void initialize() {
        super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Page Count:");
        setPageCount(getInput(getPageCount()));
    }

    @Override
    public void sellItem() {
        System.out.println("Selling "+ getBrand() + " Notebook with "+ getPageCount() +" pages...");
    }
}
