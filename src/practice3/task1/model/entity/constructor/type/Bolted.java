package practice3.task1.model.entity.constructor.type;

import practice3.task1.model.entity.constructor.ConstructorToys;

public class Bolted extends ConstructorToys {

    private int numberOfScrews;

    public Bolted(String name, double price, double weight, int numberOfDetails, int numberOfScrews) {
        super(name, price, weight, numberOfDetails);
        this.numberOfScrews = numberOfScrews;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfScrews=" + numberOfScrews +
                '}';
    }
}