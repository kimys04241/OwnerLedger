package com.ysking.ownerledger.customerdata;

/**
 * Created by alfo06-25 on 2018-05-24.
 */

public class CustomerData {

    private int no;
    private String name;
    private String phone;
    private String birth;
    private String gender;
    private String address;
    private String detail;

    public CustomerData() {
    }

    public CustomerData(int no, String name, String phone, String birth, String gender, String address, String detail) {
        this.no = no;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.detail = detail;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
