package com.example.demo.producer;

public class ProducerDTO {

    private Long id;

    private String name;

    private Integer status;

    public ProducerDTO(Long id, String name, Integer status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public ProducerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
        this.status=1;
    }

    public ProducerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
