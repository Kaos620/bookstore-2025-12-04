package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class Mouse extends ComputerHardware{
    private int dpi;
    private int numOfButtons;

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public int getNumOfButtons() {
        return numOfButtons;
    }

    public void setNumOfButtons(int numberOfButtons) {
        this.numOfButtons = numberOfButtons;
    }

    public Mouse(String brand, int numOfButtons, int dpi, double price) {
        super(brand);
        this.numOfButtons = numOfButtons;
        this.dpi = dpi;
    }

    public Mouse(){ }

    @Override
    public void initialize(Scanner input) {
        super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Mouse`s number of buttons: ");
        setNumOfButtons(getInput(input, getNumOfButtons()));
        System.out.println("Enter Mouse`s max DPI: ");
        setDpi(getInput(input, getDpi()));
    }

    @Override
    public void edit(Scanner input) {

    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + getBrand() + " mouse...");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mouse mouse = (Mouse) o;
        return dpi == mouse.dpi && numOfButtons == mouse.numOfButtons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dpi, numOfButtons);
    }
}
