/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.ItemController;

import edu.ijse.mvc.ItemDto.CustomerDto;
import edu.ijse.mvc.model.CustomerModel;

/**
 *
 * @author pasan
 */
public class CustomerController {
    private CustomerModel customerModel = new CustomerModel();
    
    public CustomerDto getCustomer(String id) throws Exception{
        return customerModel.getCustomer(id);
    }
}
