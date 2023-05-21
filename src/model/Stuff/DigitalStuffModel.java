package model.Stuff;

public abstract class DigitalStuffModel extends StuffModel {
    private final double weight;
    private final String girth;
    DigitalStuffModel(String stuffName, double stuffPrice, int stuffInventory, double weight, String girth)
    {   super(stuffName, stuffPrice, stuffInventory,StuffKindModel.DIGITALSTUFF);
        this.weight=weight;
        this.girth=girth;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getGirth() {
        return this.girth;
    }

    @Override
    public String toString() {
        return super.toString()+
                " weight=" + weight +
                ", girth='" + girth + '\''
                ;
    }
}

