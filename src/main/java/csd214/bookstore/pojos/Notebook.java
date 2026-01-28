package csd214.bookstore.pojos;

import java.util.Objects;

public class Notebook extends Stationery{

    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Notebook() {

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return pageCount == notebook.pageCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pageCount);
    }
}
