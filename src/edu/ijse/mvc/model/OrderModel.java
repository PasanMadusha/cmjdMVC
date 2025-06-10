/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.Db.DbConnection;
import edu.ijse.mvc.ItemDto.OrderDto;
import edu.ijse.mvc.ItemDto.OrderDetailDto;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author pasan
 */
public class OrderModel {
    public  String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos)throws Exception{
        Connection connection = DbConnection.getInstance().getConnection();
        
        try {
            connection.setAutoCommit(false);
            
            String orderSql = "INSERT INTO orders VALUES(?,?,?)";
            PreparedStatement orderStatement = connection.prepareStatement(orderSql);
            orderStatement.setString(1, orderDto.getOrderId());
            orderStatement.setString(2, orderDto.getDate());
            orderStatement.setString(3, orderDto.getCustId());
            
            boolean isOrdersaved = orderStatement.executeUpdate() > 0;
            
            if (isOrdersaved) {
                boolean isOrderDetailSaved = true;
                String orderDetailSql = "INSERT INTO orderdetail VALUES(?,?,?,?)";
                for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    PreparedStatement orderDetailStatement = connection.prepareStatement(orderDetailSql);
                    orderDetailStatement.setString(1, orderDto.getOrderId());
                    orderDetailStatement.setString(2, orderDetailDto.getItemCode());
                    orderDetailStatement.setInt(3, orderDetailDto.getQty());
                    orderDetailStatement.setInt(4, orderDetailDto.getDiscount());
                    
                    if (!(orderDetailStatement.executeUpdate() > 0)) {
                        isOrderDetailSaved = false;
                        
                    }
                }
            
                if (isOrderDetailSaved) {
                    boolean isItemUpdate = true;
                    String itemUpdatesql = "UPDATE Item SET QtyInHand = QtyOnHand - ? WHERE ItemCode = ?";
                    for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                        PreparedStatement itemStatement = connection.prepareStatement(itemUpdatesql);
                        itemStatement.setInt(1, orderDetailDto.getQty());
                        itemStatement.setString(2, orderDetailDto.getItemCode());
                        
                        if (!(itemStatement.executeUpdate() > 0)) {
                            isItemUpdate = false;
                        }
                    }
                    if (isItemUpdate) {
                        connection.commit();
                        return  "Success";
                    }else{
                        connection.rollback();
                        return "Item Update Error";
                    }
                }else{
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            }
            else{
                connection.rollback();
                return "Order Save Error";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            return "Order Save Error";
        }finally{
            connection.setAutoCommit(true);
        }
    }
}
