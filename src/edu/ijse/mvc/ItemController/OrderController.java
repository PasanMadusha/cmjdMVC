/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.ItemController;

import edu.ijse.mvc.ItemDto.OrderDetailDto;
import edu.ijse.mvc.ItemDto.OrderDto;
import edu.ijse.mvc.model.OrderModel;
import java.util.ArrayList;

/**
 *
 * @author pasan
 */
public class OrderController {
    
    private OrderModel orderModel = new OrderModel();
    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> detailDtos) throws  Exception{
        return orderModel.placeOrder(orderDto, detailDtos);
    }    
}
