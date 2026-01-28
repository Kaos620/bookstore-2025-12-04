package csd214.bookstore.pojos;

import java.util.Objects;

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

    @Override
    public void initialize() {
        super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Mouse`s number of buttons: ");
        setNumOfButtons(getInput(getNumOfButtons()));
        System.out.println("Enter Mouse`s max DPI: ");
        setDpi(getInput(getDpi()));
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
