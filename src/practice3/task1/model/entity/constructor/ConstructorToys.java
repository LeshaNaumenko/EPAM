package practice3.task1.model.entity.constructor;

import practice3.task1.model.entity.Toy;

public abstract class ConstructorToys extends Toy {

    private int numberOfDetails;

    public ConstructorToys(String name, double price, double weight, int numberOfDetails) {
        super(name, price, weight);
        this.numberOfDetails = numberOfDetails;
    }

    public int getNumberOfDetails() {
        return numberOfDetails;
    }

    public void setNumberOfDetails(int numberOfDetails) {
        this.numberOfDetails = numberOfDetails;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", details=" + numberOfDetails;
    }
}
