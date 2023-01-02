package models;

public class Division {
    private int divisionId;
    private String divisionName;
    private int regionId;

    public Region(int int1, String string) {
    }
    public int getDivisionId(){
        return this.divisionId;
    }
    public void setDivisionId(int divisionId){
        this.divisionId = divisionId;
    }
    public String getDivisionName(){
        return this.divisionName;
    }
    public void setDivisionName(String divisionName){
        this.divisionName = divisionName;
    }
    public int getRegionId(){
        return this.regionId
    }
    public void setRegionId(int regionId){
        this.regionId = regionId;
    }
}