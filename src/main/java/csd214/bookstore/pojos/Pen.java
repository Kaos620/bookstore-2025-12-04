package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class Pen extends Stationery{

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Pen(String brand, String color, double price) {
        super(brand);
        this.color = color;
    }

    public Pen() {

    }

    @Override
    public void edit(Scanner input) {

    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Pen Color:");
        setColor(getInput(input, "Unknown color"));
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + getColor() + " pen...");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
