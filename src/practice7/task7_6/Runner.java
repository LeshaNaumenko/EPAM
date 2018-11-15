package practice7.task7_6;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public void run(){
        List<Integer> integerList = Stream
                .iterate(10, n->n+10)
                .limit(10)
                .map(n->n/2)
                .collect(Collectors.toList());
        System.out.println("integerList = " + integerList);
        List<Person> list = createList();
        list.forEach(System.out::println);
        System.out.println("======");
        list.stream().filter(person -> person.getSex() == Person.Sex.MALE && person.getAge()>=18&& person.getAge()<=55)
                .forEach(System.out::println);
        long sum = 0;
        long count = 0;
        for (Person person : list) {
            if (person.getSex() == Person.Sex.FEMALE) {
                int age = person.getAge();
                sum += age;
                count++;
            }
        }
        double asDouble = (count > 0 ? OptionalDouble.of((double) sum / count) : OptionalDouble.empty()).getAsDouble();
        System.out.println("asDouble = " + asDouble);
    }

    private List<Person> createList(){

        return Arrays.asList(
                new Person("John", 29, Person.Sex.MALE),
                new Person("Lina", 20, Person.Sex.FEMALE),
                new Person("Max", 22, Person.Sex.MALE),
                new Person("Alina", 19, Person.Sex.FEMALE),
                new Person("Alex", 17 , Person.Sex.MALE),
                new Person("Dima", 15, Person.Sex.MALE),
                new Person("Tanya", 20, Person.Sex.FEMALE),
                new Person("Nataliya", 30, Person.Sex.FEMALE),
                new Person("Oleg", 26, Person.Sex.MALE),
                new Person("Lubov", 40, Person.Sex.FEMALE)
        );

    }
}
