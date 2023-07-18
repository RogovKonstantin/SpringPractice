package org.example.dto;

import org.example.models.Client;

public class ClientDto {
    private Integer id;
    private String login;
    private String phoneNumber;
    public ClientDto(Integer id, String login, String phoneNumber) {
        this.id = id;
        this.login = login;
        this.phoneNumber = phoneNumber;
    }

    public ClientDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
