package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public abstract class Stationery extends Product{
    private String brand;

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public Stationery() { }

    public Stationery(String brand) {
        this.brand = brand;
    }

    public String toString() {
        return "Stationary{" + "brand = '" + brand + '\'' + "}";
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), brand);
    }

    @Override
    public void edit(Scanner input) {
        // 1. Edit Parent fields (Title, Price, Copies)
       // super.edit();

        // 2. Edit Self fields
        System.out.println("Edit Author [" + this.brand + "]:");
        this.brand = getInput(input, this.brand);
    }

    @Override
    public void initialize(Scanner input) {
      //  super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Brand:");
        setBrand(getInput(input, "Generic"));
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
