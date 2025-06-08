/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.ItemDto.ItemDto;
import java.sql.Connection;
import edu.ijse.mvc.Db.DbConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author pasan
 */
public class ItemModel {
    public String saveItem(ItemDto itemDto) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO item VALUES(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemDto.getId());
        statement.setString(2, itemDto.getDesc());
        statement.setString(3, itemDto.getPack());
        statement.setDouble(4, itemDto.getUnitPrice());
        statement.setInt(5, itemDto.getQth());
        
        return statement.executeUpdate() > 0 ? "Success":"Fail";
    }
    
    public String updateItem(ItemDto itemDto) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET Description =?,PackSize = ?,UnitPrice = ?,QtyOnHand = ? WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, itemDto.getDesc());
        statement.setString(2, itemDto.getPack());
        statement.setDouble(3, itemDto.getUnitPrice());
        statement.setInt(4, itemDto.getQth());
        statement.setString(5, itemDto.getId());
        
        return statement.executeUpdate() > 0 ? "Success":"Fail";
    }
    
    public String deleteItem(String code) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, code);        
        return statement.executeUpdate() > 0 ? "Success":"Fail";
    }
    
    public ItemDto searchItem(String code) throws ClassNotFoundException, SQLException{
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE ItemCode =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, code);
        
        ResultSet rst = statement.executeQuery();
        
        if (rst.next()) {
            return new ItemDto(rst.getString("ItemCode"),rst.getString("Description"),rst.getString("PackSize"),rst.getDouble("UnitPrice"),rst.getInt("QtyOnHand"));
            
        }
        return null;    

    }
    
    public ArrayList<ItemDto> getAllItem() throws Exception{
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        while(rst.next()){
            itemDtos.add(new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"), 
                    rst.getInt("QtyOnHand")));
        }
        return itemDtos;
    }
    
}
