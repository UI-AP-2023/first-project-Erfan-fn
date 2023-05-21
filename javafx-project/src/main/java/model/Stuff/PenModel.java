package model.Stuff;

public class PenModel extends StationeryModel{
    private final String color;

    public PenModel(String stuffName, double stuffPrice, int stuffInventory, String madeCountry, String color) {
        super(stuffName, stuffPrice, stuffInventory, madeCountry);
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:Pen " +
                "color='" + color + '\''
                ;
    }
}
