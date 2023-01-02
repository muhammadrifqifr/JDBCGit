package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Region;

public class RegionDAO {

    private Connection con;

    public RegionDAO(Connection connection){
        this.con = connection;
    }

    public List<Region> getAll(){
        List<Region> region = new ArrayList<>();
        String query = "SELECT regionId, regionName FROM REGION"; //query ke db
        try {
            ResultSet resultSet = con.prepareStatement(query).executeQuery();  //method ini akan menghasilkan nilai kembalian berupa objek resultSet. Digunakan untuk mengambil data dari db
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return region;
    }

    // Insert
    public boolean insertData(Region region){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO REGION(regionId, regionName) VALUES (?,?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.executeUpdate();
            System.out.println("Insert Data Done!");
            return true; // jika query berhasil
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false; // jika query gagal
    }

    //Update
    public boolean updateData(Region region){
        try {
            String query = "UPDATE region SET regionId = ?, regionName = ? WHERE regionId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.setInt(3, region.getRegionId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //Delete
    public boolean deleteData(Region region){
        try {
            String query = "DELETE FROM region WHERE regionId = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

// try, catch, exception : error program not error compile