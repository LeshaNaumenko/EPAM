package Practice2.Task2_Shapes.model.entity;

public class Triangle extends Shape {

    private int height;
    private int base;

    public Triangle(String shapeColor, int height, int base) {
        super(shapeColor);
        this.height = height;
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public double calcArea() {
        return 0.5 * height * base;
    }

    @Override
    public void draw() {

    }

    @Override
    public String toString() {
        return "Triangle\t{" +
                super.toString() +
                ",\theight=" + height +
                ",\tbase=" + base +
                '}';
    }
}
