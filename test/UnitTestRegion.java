package test;

import JDBC.daos.RegionDAO;
import JDBC.models.Region;
import JDBC.tools.DBConnection;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTestRegion {

    DBConnection con = new DBConnection();

    @Test
    public void insert(){
        //Arrange
        Integer id = 1;
        String Name = "Great Britain";
        boolean result = true;

        //Act & Assert
        RegionDAO insertR = new RegionDAO(con.getConnection());
        Region region = new Region();
        region.setRegionId(id);
        region.setRegionName(Name);

        assertEquals(result, insertR.insertData(region));
    }

    @Test
    public void update(){
        Integer id = 2;
        String Name = "Scandinavia";
        boolean result = true;

        RegionDAO updateR = new RegionDAO(con.getConnection());
        Region region = new Region();
        region.setRegionId(id);
        region.setRegionName(Name);
        region.setRegionId(id);

        assertEquals(result, updateR.updateData(region));
    }

    @Test
    public void delete(){
        Integer id = 3;
        boolean result = true;

        RegionDAO deleteR = new RegionDAO(con.getConnection());
        Region region = new Region();
        region.setRegionId(id);

        assertEquals(result, deleteRegD.delete(region));
    }
}

