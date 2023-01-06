package com.example.demo.daos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.sql.PreparedStatement;
//import java.sql.*;
import com.example.demo.models.Division;

public class DivisionDAO {
    private Connection con;

    public DivisionDAO(Connection connection){
        this.con = connection;
    }

    public List<Division> getAll(){
        List<Division> divisions = new ArrayList<>();
        String query = "SELECT * FROM tb_m_division"; 
        try {
            ResultSet resultSet = con.prepareStatement(query).executeQuery(); 
            while (resultSet.next()){
                Division division = new Division();
                division.setId(resultSet.getInt(1));
                division.setName(resultSet.getString(2));
                //division.setRegion("East Java");
                divisions.add(division);
                //System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return divisions;
    }
}

// // Get by ID
//     public Division getById(int id){
//         String query = "SELECT * FROM tb_m_division WHERE Id = ?";
//         Division division = new Division();
//         try {
//             PreparedStatement prepareStatement  = con.prepareStatement(query);
//             prepareStatement.setInt(1,id);
//             ResultSet resultSet = prepareStatement.executeQuery();
//             while (resultSet.next()){
//                 region.setId(resultSet.getInt(1));
//                 region.setName(resultSet.getString(2));
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return division;
//     }

    //Insert
    // public boolean insert(Division division){
    //     try {
    //         PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO tb_m_division(name) VALUES(?)");
    //         preparedStatement.setInt(1, division.getId());
    //         preparedStatement.setString(2, division.getName());
    //         //preparedStatement.setInt(3, division.getRegionId());
    //         int temp = preparedStatement.executeUpdate();
    //         //System.out.println("Insert Data Division Success");
    //         return temp > 0;
    //     } catch (SQLException e){
    //         e.printStackTrace();
    //     }
    //     return false;
    // }

    //Update
    // public boolean update(Division division){
    //     try {
    //         String query = "UPDATE tb_m_division SET id = ?, name = ? WHERE Id = ?";
    //         PreparedStatement preparedStatement = con.prepareStatement(query);
    //         preparedStatement.setInt(1, division.getId());
    //         preparedStatement.setString(2, division.getnName());
    //         //preparedStatement.setInt(3, division.getRegionId());
    //         preparedStatement.setInt(3, division.getId());
    //         int temp = preparedStatement.executeUpdate();
    //         return temp > 0;
    //     } catch (SQLException e){
    //         e.getMessage();
    //     }
    //     return false;
    // }

    //Delete
    // public boolean delete(Integer Id){
    //     try {
    //         String query = "DELETE FROM tb_m_division WHERE id = ?";
    //         PreparedStatement preparedStatement = con.prepareStatement(query);
    //         preparedStatement.setInt(1, Id);
    //         int temp = preparedStatement.executeUpdate();
    //         return temp > 0;
    //     } catch (SQLException e){
    //         e.printStackTrace();
    //     }
    //     return false;
    // }

	// public Object getConnection() {
	// 	return null;
	// }

