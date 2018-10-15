package practice3.task1.model.entity.doll;

import practice3.task1.model.entity.Toy;

public class Doll extends Toy {
    private String type;

    public Doll(String name, double price, double weight, String type) {
        super(name, price, weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", type='" + type + '\'' +
                '}';
    }
}
