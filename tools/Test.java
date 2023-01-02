package tools;
import models.Division;
import models.Region;
import models.Division;

public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        DbConnection con = new DbConnection ();
        System.out.println(con.getConnection());

        //Read Data Region
        RegionDAO regionDAO = new RegionDAO(con.getConnection());
        for (Region region : regionDAO.getAll()){
            System.out.println(region.getRegionId());
            System.out.println(region.getRegionName());
        }

        //Insert Data Region
        RegionDao rDAO = new RegionDAO(con.getConnection());
        Region region = new Region();
        region.setRegionId(1);
        region.setRegionName("Balcan");
        System.out.println(rDAO.insertData(region));

        //Update Data Region
        RegionDAO rDAO = new RegionDAO(con.getConnection());
        Region region = new Region();
        region.setRegionId(1);
        region.setRegionName("Scandinavia");
        region.setRegionId(1);
        System.out.println(rDAO.updateData(region));

        //Read Data Division
        DivisionDAO dDAO = new DivisionDAO(con.getConnection());
        for (Division division : dDAO.getAll()) {
            System.out.println(division.getdivisionId());
            System.out.println(division.getdivisionName());
            System.out.println(division.getRegionId());
        }

        //Insert Data Division
        DivisionDAO dDAO = new DivisionDAO(con.getConnection());
        Division division = new Division();
        division.setdivisioId(1);
        division.setdivisionName("HR");
        division.setRegionId(1);
        System.out.println(dDAO.insertData(division));

        //Update Data Division
        DivisionDAO dDAO = new DivisionDAO(con.getConnection());
        Division division = new Division();
        division.setdivisionId(1);
        division.setdivisionName("Accounting");
        division.setRegionId(2);
        division.setId(1);
        System.out.println(dDAO.updateData(division));

        //Delete Data Division
        DivisionDAO dDAO1 = new DivisionDAO(con.getConnection());
        Division division1 = new Division();
        division.setdivisionId(2);
        System.out.println(dDAO1.deleteData(division1));

        //Join
        DivisionDAO dDAO = new DivisionDAO(con.getConnection());
        for (Division division : dDAO.getJoin()) {
            System.out.println(division.getdivisionId());
            System.out.println(division.getdivisionName());
            System.out.println(division.getRegionId());
        }
        RegionDAO rDAO = new RegionDAO(con.getConnection())
        for (Region region : rDAO.getJoin()) {
            System.out.println(region.getdivisionId());
            System.out.println(region.getdivisionName());
        }
    }
}
