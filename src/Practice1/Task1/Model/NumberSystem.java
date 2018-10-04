package Practice1.Task1.Model;

public enum  NumberSystem {

    BASE2(2,"Base-2"),
    BASE8(8,"Base-8"),
    BASE16(16,"Base-16");

    private int id;
    private String name;
    private String number;

    NumberSystem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}