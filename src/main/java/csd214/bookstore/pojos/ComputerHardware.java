package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public abstract class ComputerHardware extends Product{
    private String brand;
    private String category;

    public void setPrice(double price) {
        this.price = price;
    }

    public ComputerHardware(String brand, String category, double price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    private double price;

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public ComputerHardware() {

    }

    public ComputerHardware(String brand){
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return "Computer Hardware{" + " = '" + category + " " + brand + '\'' + "}";
    }

    public int hashCode() {
        return Objects.hashCode(getBrand());
    }

    @Override
    public void edit(Scanner input) {
        // 1. Edit Parent fields (Title, Price, Copies)
        // super.edit();

        // 2. Edit Self fields
        System.out.println("Edit  [" + this.brand + "]:");
        this.brand = getInput(input, this.brand);
        System.out.println("Edit  [" + this.category + "]:");
        this.category = getInput(input, this.category);
    }

    @Override
    public void initialize(Scanner input) {
        //  super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Category: ");
        setCategory(getInput(input, "Mouse/Keyboard etc..."));
        System.out.println("Enter Brand: ");
        setBrand(getInput(input, "Generic"));
    }

    @Override
    public double getPrice() {
        return 0;
    }



}
