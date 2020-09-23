package com.iza.entity;

/**
 * projectName:  bankSystem
 *
 * @author: xuwei
 * ime:  2020/9/3 19:45
 * description:
 */
public class User {
    private Integer id;
    private String bankCode;
    private String password;
    private Double balance;
    private Integer status;
    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public User() {
    }

    public User(Integer id, String bankCode, String password, Double balance, Integer status) {
        this.id = id;
        this.bankCode = bankCode;
        this.password = password;
        this.balance = balance;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", bankCode='" + bankCode + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }


}
