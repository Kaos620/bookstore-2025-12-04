package csd214.bookstore.pojos;

import java.util.Objects;

public class Keyboard extends ComputerHardware{
    private int sizeType;
    private boolean wirelessAvailable;
    private int stock;

    public int getSizeType() {
        return sizeType;
    }

    public void setSizeType(int sizeType) {
        this.sizeType = sizeType;
    }

    public boolean isWirelessAvailable() {
        return wirelessAvailable;
    }

    public void setWirelessAvailable(boolean wirelessAvailable) {
        this.wirelessAvailable = wirelessAvailable;
    }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public Keyboard(String brand, int sizeType, boolean wirelessAvailable, int stock) {
        super(brand);
        this.sizeType = sizeType;
        this.wirelessAvailable = wirelessAvailable;
        this.stock = stock;
    }

    public Keyboard() { };

    @Override
    public void initialize() {
        super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter keyboard`s size: ");
        setSizeType(getInput(getSizeType()));
        System.out.println("Is wireless connection available?: ");
        setWirelessAvailable(getInput(isWirelessAvailable()));
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + getBrand() + " keyboard...");
        setStock(stock -1);
        System.out.println(getStock() + " units available in stock");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Keyboard keyboard = (Keyboard) o;
        return sizeType == keyboard.sizeType && wirelessAvailable == keyboard.wirelessAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sizeType, wirelessAvailable);
    }

}
