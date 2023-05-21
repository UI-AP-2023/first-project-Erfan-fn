package model.Stuff;

import model.Stuff.StuffKindModel;
import model.Stuff.StuffModel;

public abstract class VehicleModel extends StuffModel {
    private final String companyName;
    VehicleModel(String stuffName, double stuffPrice, int stuffInventory, String companyName)
    {
        super(stuffName, stuffPrice, stuffInventory,StuffKindModel.VEHICLE);
        this.companyName=companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return super.toString()+
                " companyName='" + companyName + '\''
                ;
    }
}
