package controller.common_pattern;

import static controller.common_pattern.CommandLogger.loggerCom;

public class ExitCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" User completed");
        System.exit(0);
    }
}
