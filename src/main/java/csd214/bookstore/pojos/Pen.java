package csd214.bookstore.pojos;

public class Pen extends Stationery{

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void initialize() {
        super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Pen Color:");
        setColor(getInput(getColor()));
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + getColor() + " pen...");
    }
}
