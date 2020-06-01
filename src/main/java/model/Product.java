package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int amount;
    private String species;

    public Product() {
    }

    public Product(int id, String name, float price, int amount, String species) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
