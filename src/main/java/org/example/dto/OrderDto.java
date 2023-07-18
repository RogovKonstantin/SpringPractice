package org.example.dto;

public class OrderDto {
    private Integer id;

    private Integer managerId;

    private Integer clientId;
    private ManagerDto manager;

    private ClientDto client;

    public OrderDto(Integer id, Integer managerId, Integer clientId) {
        this.id = id;
        this.managerId = managerId;
        this.clientId = clientId;
    }

    public OrderDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public ManagerDto getManager() {
        return manager;
    }

    public void setManager(ManagerDto manager) {
        this.manager = manager;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", managerId=" + managerId +
                ", clientId=" + clientId +
                ", manager=" + manager +
                ", client=" + client +
                '}';
    }
}
