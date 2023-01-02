package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Division;

public class DivisionDao {

    private Connection con;

    public DivisionDao(Connection connection){
        this.con = connection;
    }

    public List<Division> getAll(){
        List<Division> division = new ArrayList<>();
        String query = "SELECT * FROM division";
        try {
            ResultSet resultSet = con.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return division;
    }

    public List<Division> getJoin(){
        List<Division> division = new ArrayList<>();
        String query = "SELECT * FROM division JOIN region ON division.regionId = region.regionId; ";
        try {
            ResultSet resultSet = con.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + 
                                resultSet.getString(2) + " " + 
                                resultSet.getInt(3) + " " +
                                resultSet.getInt(4 ) + " " +
                                resultSet.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return division;
    }

    //Insert
    public boolean insertData(Division division){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO division(divisionId, divisionName, regionId) VALUES(?,?,?)");
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.setString(2, division.getDivisionName());
            preparedStatement.setInt(3, division.getRegionId());
            preparedStatement.executeUpdate();
            System.out.println("Insert Data Division Success");
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //Update
    public boolean updateData(Division division){
        try {
            String query = "UPDATE division SET divisionId = ?, divisionName = ?, regionId = ? WHERE Id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, division.getdivisionId());
            preparedStatement.setString(2, division.getdivisionName());
            preparedStatement.setInt(3, division.getRegionId());
            preparedStatement.setInt(4, division.getdivisionId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //Delete
    public boolean deleteData(Division division){
        try {
            String query = "DELETE FROM division WHERE divisionId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, division.getdivisionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}