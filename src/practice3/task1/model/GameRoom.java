package practice3.task1.model;

import practice3.task1.model.entity.doll.Doll;
import practice3.task1.model.entity.Toy;
import practice3.task1.model.entity.constructor.type.Bolted;
import practice3.task1.model.entity.constructor.type.LegoType;
import practice3.task1.model.entity.constructor.type.Magnetic;

import java.util.Arrays;
import java.util.Comparator;

public class GameRoom<T extends Toy> {

    T[] toys;

    public void setToys(T[] toys) {
        this.toys = toys;
    }

    public T[] getToys() {
        return toys;
    }

    public T[] sortByPrice() {
        T[] temp = Arrays.copyOf(toys, toys.length);
        Arrays.sort(temp, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return temp;
    }


    public double getSumOfPrice() {
        double sum = 0;
        for (T toy : toys) {
            sum += toy.getPrice();
        }
        return sum;
    }
    public T[] getFourParam() {
        Toy[] temp = new Toy[toys.length];
        int counter = 0;
        for (T toy : toys) {
            if (toy instanceof Doll) {
                temp[counter++] = toy;
            }
        }
        return (T[]) Arrays.copyOf(temp, counter);
    }

    public T[] getFiveParam() {
        Toy[] temp = new Toy[toys.length];
        int counter = 0;
        for (T toy : toys) {
            if (toy instanceof Magnetic) {
                temp[counter++] = toy;
            }
            if (toy instanceof Bolted) {
                temp[counter++] = toy;
            }
        }
        return (T[]) Arrays.copyOf(temp, counter);
    }

    public T[] getSixParam() {
        Toy[] temp = new Toy[toys.length];
        int counter = 0;
        for (T toy : toys) {
            if (toy instanceof LegoType) {
                temp[counter++] = toy;
            }
        }
        return (T[]) Arrays.copyOf(temp, counter);
    }
}