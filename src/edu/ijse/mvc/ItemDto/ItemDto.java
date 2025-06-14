/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.ItemDto;

/**
 *
 * @author pasan
 */
public class ItemDto {
    private String id;
    private String desc;
    private String pack;
    private double unitPrice;
    private int qoh;
    
    public ItemDto(){
    }
    
    public ItemDto(String id, String desc,String pack,double unitPrice,int qoh){
        this.id = id;
        this.desc = desc;
        this.pack = pack;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the pack
     */
    public String getPack() {
        return pack;
    }

    /**
     * @param pack the pack to set
     */
    public void setPack(String pack) {
        this.pack = pack;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qoh
     */
    public int getQth() {
        return qoh;
    }

    /**
     * @param qth the qoh to set
     */
    public void setQth(int qth) {
        this.qoh = qth;
    }

    @Override
    public String toString() {
        return "ItemDto{" + "id=" + id + ", desc=" + desc + ", pack=" + pack + ", unitPrice=" + unitPrice + ", qth=" + qoh + '}';
    }   
}

