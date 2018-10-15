package practice3.task1.model.entity.constructor.type;

import practice3.task1.model.entity.constructor.ConstructorToys;

public class Magnetic extends ConstructorToys {
    private String form;

    public Magnetic(String name, double price, double weight, int numberOfDetails, String form) {
        super(name, price, weight, numberOfDetails);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", form='" + form + '\'' +
                '}';
    }

}
