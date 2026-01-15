package csd214.bookstore.pojos;

import java.util.Objects;

public abstract class Stationery extends Product{
    private String brand;

    public void setBrand(String brand){
        this.brand = brand;
    }

    public Object getBrand() {
        return brand;
    }

    public Stationery() {

    }

    public String toString() {
        return "Stationary{" + "brand = '" + brand + '\'' + "}";
    }

    public int hashCode() {
        return Objects.hashCode(getBrand());
    }

    @Override
    public void edit() {
        // 1. Edit Parent fields (Title, Price, Copies)
       // super.edit();

        // 2. Edit Self fields
        System.out.println("Edit Author [" + this.brand + "]:");
        this.brand = getInput(this.brand);
    }

    @Override
    public void initialize() {
      //  super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Brand:");
        setBrand(getInput(("Generic")));
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
