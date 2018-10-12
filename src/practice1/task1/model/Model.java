package practice1.task1.model;

public class Model {

    private int value;
    private int sysNumberFromConsole;
    private NumberSystem b2 = NumberSystem.BASE2;
    private NumberSystem b8 = NumberSystem.BASE8;
    private NumberSystem b16 = NumberSystem.BASE16;
    private StringBuilder stringBuilder = new StringBuilder();


    public void calculate() {
        if (sysNumberFromConsole == 0) {

            stringBuilder.setLength(0);
            getValueOfTheNumberSystemFromBase(value,2);
            b2.setNumber(stringBuilder.reverse().toString());

            stringBuilder.setLength(0);
            getValueOfTheNumberSystemFromBase(value,8);
            b8.setNumber(stringBuilder.reverse().toString());

            stringBuilder.setLength(0);
            getValueOfTheNumberSystemFromBase(value,16);
            b16.setNumber(stringBuilder.reverse().toString());
        } else {
            stringBuilder.setLength(0);
            getValueOfTheNumberSystemFromBase(value,sysNumberFromConsole);
            getNumberSystem(sysNumberFromConsole).setNumber(stringBuilder.reverse().toString());
        }
    }

    private void getValueOfTheNumberSystemFromBase(int valueInMethod ,int numberSystems) {

        if (value == 0) {
            stringBuilder.append(0);
            return;
        }
        int dif = division(valueInMethod, numberSystems);
        remainder(valueInMethod, numberSystems);
        if (dif > numberSystems - 1) {
            getValueOfTheNumberSystemFromBase(dif, numberSystems);
        } else {
            if (numberSystems == 16&&dif ==0) {
                return;
            }
            stringBuilder.append(dif);
        }
    }

    private void remainder(int i, int numberSystems) {
        String[] forHexadecimal = new String[]{"A","B","C","D","E","F"};
        int rem=i % numberSystems;
        //System.out.println(rem);
        if (numberSystems == 16) {
            if (10<=rem&&rem<=16) {
                stringBuilder.append(forHexadecimal[i % numberSystems - 10]);
            }else
            stringBuilder.append(i % numberSystems);
            return;
        }
        stringBuilder.append(i % numberSystems);
    }

    private int division(int i, int numberSystems) {
        return i / numberSystems;
    }


    public NumberSystem getNumberSystem(int base) {

        switch (base) {
            case 2:
                return b2;
            case 8:
                return b8;
            case 16:
                return b16;
            default:
                return b2;
        }
    }

    public int getSysNumberFromConsole() {
        return sysNumberFromConsole;
    }

    public void setSysNumberFromConsole(int sysNumberFromConsole) {
        this.sysNumberFromConsole = sysNumberFromConsole;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
