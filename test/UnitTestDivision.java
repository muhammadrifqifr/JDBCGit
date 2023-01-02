package test;

import JDBC.daos.DivisionDAO;
import JDBC.models.Division;
import JDBC.tools.DBConnection;
import daos.DivisionDao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTestDivision {

    DBConnection con = new DBConnection();

    @Test
    public void insert(){
        //Arrange
        Integer id = 4;
        String Name = "HR";
        boolean result = true;

        //Act & Assert
        DivisionDAO insertD = new DivisionDAO(con.getConnection());
        Division division = new Division();
        division.setDivisionId(id);
        division.setDivisionName(Name);

        assertEquals(result, insertD.insertData(division));
    }

    @Test
    public void update(){
        Integer id = 3;
        String Name = "Finance";
        boolean result = true;

        DivisionDAO updateD = new DivisionDAO(con.getConnection());
        Division division = new Division();
        division.setDivisionId(id);
        division.setDivisionName(Name);
        division.setDivisionId(id);

        assertEquals(result, updateD.updateData(division));
    }

    @Test
    public void delete(){
        Integer id = 2;
        boolean result = true;

        DivisionDAO deleteD = new DivisionDAO(con.getConnection());
        Division division = new Division();
        division.setDivisionId(id);

        assertEquals(result, deleteD.delete(division));
    }
}


