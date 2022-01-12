package com.piorini.userapi.dto;

import com.piorini.userapi.model.User;

import java.util.Date;

public class UserDTO {

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phoneNumber;
    private Date creationDate;

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setName(user.getName());
        userDTO.setCpf(user.getCpf());
        userDTO.setAddress(user.getAddress());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setCreationDate(user.getCreationDate());

        return userDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
