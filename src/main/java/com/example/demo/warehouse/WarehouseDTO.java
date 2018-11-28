package com.example.demo.warehouse;

public class WarehouseDTO {
    private Long id;

    private String name;

    private Integer status;

    public WarehouseDTO(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public WarehouseDTO(String name) {

        this.name = name;
        this.status=1;
    }

    public WarehouseDTO(){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}


