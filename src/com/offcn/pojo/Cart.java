package com.offcn.pojo;

public class Cart {
    private Integer id;
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
