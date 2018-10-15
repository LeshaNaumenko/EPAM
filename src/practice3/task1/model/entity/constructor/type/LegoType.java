package practice3.task1.model.entity.constructor.type;

import practice3.task1.model.entity.constructor.ConstructorToys;

public class LegoType extends ConstructorToys {
    private String series;
    private String category;

    public LegoType(String name, double price, double weight, int numberOfDetails, String series, String category) {
        super(name, price, weight, numberOfDetails);
        this.series = series;
        this.category = category;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", series='" + series + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
