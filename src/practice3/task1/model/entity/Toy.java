package practice3.task1.model.entity;

public abstract class Toy {
    private static int counter=1;
    private int id = counter++;
    private String name;
    private double price;
    private double weight;

    public Toy(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%-8s {" +
                "id=%-3d" +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", weight=" + weight,this.getClass().getSimpleName(),id);
    }
}
