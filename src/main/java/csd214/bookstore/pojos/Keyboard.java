package csd214.bookstore.pojos;

public class Keyboard extends ComputerHardware{
    private int sizeType;
    private boolean wirelessAvailable;

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
    }

}
