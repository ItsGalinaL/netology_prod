package ru.netology.prod;

public class Smartphone extends Product {

    private String creator;

    public Smartphone(int id, String name) {
        super(id, name);
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
