package practice1.task3.model;

public class Model {
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPiramid() {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = number, leng = number, other = number; i > 0; i--, other--, leng++) {
            int temp = 0;
            for (int j = 1; j <= leng; j++) {
                if (j < other)
                    stringBuilder.append(" ");
                else if (j <= number)
                    stringBuilder.append(++temp);
                else stringBuilder.append(--temp);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

        /*   COMPACT FORM
        for (int i= number,leng = number,other= number,temp = 0; i >0; i--,other--,leng++, temp=0) {
            //int temp = 0;
            for (int j = 1; j <=leng; j++) {
                System.out.print((j<other)?" ":(j<=input)?++temp:--temp);
            }
            System.out.println();
        }
*/
    }
}
