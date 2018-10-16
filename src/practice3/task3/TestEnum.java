package practice3.task3;

import java.util.Arrays;

public enum TestEnum {
    MONDAY(1),
    FRIDAY(1);
    int i;

    TestEnum(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TestEnum.values()));
    }

}

