package com.kovunov;

public class Game {
    private String name;
    private int quantity;
    private Producer producer;

    public enum Producer {
        DOG, CAT, WHR
    }

    public Game(String name, int quantity, Producer producer) {
        this.name = name;
        this.quantity = quantity;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
