package model.Stuff;

public class PencilModel extends StationeryModel{
    private final PencilKindModel pencilKindModel;

    public PencilModel(String stuffName, double stuffPrice, int stuffInventory, String madeCountry, PencilKindModel pencilKindModel) {
        super(stuffName, stuffPrice, stuffInventory, madeCountry);
        this.pencilKindModel = pencilKindModel;
    }
    public PencilKindModel getPencilKindModel() {
        return pencilKindModel;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:Pencil " +
                "pencilKindModel=" + pencilKindModel
                ;
    }
}
