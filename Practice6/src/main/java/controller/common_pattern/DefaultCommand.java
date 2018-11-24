package controller.common_pattern;

import static controller.common_pattern.CommandLogger.loggerCom;

public class DefaultCommand extends Command{
    @Override
    public void execute() {
        loggerCom.warn(resourceManager.getString("WRONG_INPUT_INT_DATA"));
        bookView.printMessage(resourceManager.getString("WRONG_INPUT_INT_DATA") + "\n");

    }
}
