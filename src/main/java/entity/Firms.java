/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import java.util.List;

public class Firms {
  
    private Integer idFirm;
    private String title;
    private String phone;
    private String information;
    private List<Orders> ordersList;

    public Firms() {
    }

    public Firms(Integer idFirm) {
        this.idFirm = idFirm;
    }
    
    public Firms(String title) {
        this.title = title;
    }
    
    public Firms(Integer idFirm,String title,String phone, String information) {
        this.idFirm = idFirm;
        this.title = title;
        this.phone = phone;
        this.information = information;
    }
    
    public Firms(String title,String phone, String information) {
        this.title=title;
        this.phone=phone;
        this.information = information;
    }

    public Integer getIdFirm() {
        return idFirm;
    }

    public void setIdFirm(Integer idFirm) {
        this.idFirm = idFirm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
    
    
}
