package csd214.bookstore.pojos;

import java.util.Objects;

public abstract class ComputerHardware extends Product{
    private String brand;
    private String category;

    public void setBrand(String brand){
        this.brand = brand;
    }

    public Object getBrand() {
        return brand;
    }

    public ComputerHardware() {

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
    public void edit() {
        // 1. Edit Parent fields (Title, Price, Copies)
        // super.edit();

        // 2. Edit Self fields
        System.out.println("Edit  [" + this.brand + "]:");
        this.brand = getInput(this.brand);
        System.out.println("Edit  [" + this.category + "]:");
        this.category = getInput(this.category);
    }

    @Override
    public void initialize() {
        //  super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Category: ");
        setCategory(getInput(("Mouse/Keyboard etc...")));
        System.out.println("Enter Brand: ");
        setBrand(getInput(("Generic")));
    }

    @Override
    public double getPrice() {
        return 0;
    }

}
