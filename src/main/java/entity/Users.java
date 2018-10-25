/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.List;

public class Users {

    private Integer idUser;
    private String fio;
    private String phone;
    private Date datereg;

    private List<Orders> ordersList;

    public Users() {
    }

    public Users(Integer idUser) {
        this.idUser = idUser;
    }
    
    public Users(String fio) {
        this.fio = fio;
    }

    public Users(Integer idUser, String fio, String phone, Date datereg) {
        this.idUser= idUser;
        this.fio = fio;
        this.phone = phone;
        this.datereg = datereg;
    }
    
    public Users(String fio, String phone, Date datereg) {
        this.fio = fio;
        this.phone = phone;
        this.datereg = datereg;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDatereg() {
        return datereg;
    }

    public void setDatereg(Date datereg) {
        this.datereg = datereg;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

}
