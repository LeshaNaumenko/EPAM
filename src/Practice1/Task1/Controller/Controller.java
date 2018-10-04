package Practice1.Task1.Controller;

import Practice1.Task1.Model.Model;
import Practice1.Task1.View.InputUtility;
import Practice1.Task1.View.View;

public class Controller {
    private View view;
    private Model model;


    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void calculate() {
        model.setValue(InputUtility.inputIntValueWithScanner(view));
        int temp = InputUtility.getValueOfConditionWithScanner(view);

        model.setSysNumberFromConsole(temp);
        model.calculate();
        if (temp == 0) view.printResult(View.OUT_FOR_ALL, model.getValue(),
                model.getNumberSystem(2).getNumber(),
                model.getNumberSystem(8).getNumber(),
                model.getNumberSystem(16).getNumber());
        else
            view.printResult(view.OUT_ONLY_FOR_ONE, model.getValue(),
                    model.getNumberSystem(temp).getName(),
                    model.getNumberSystem(temp).getNumber());

    }

}
