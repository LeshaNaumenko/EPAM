package controller.common_pattern;

import utility.InputOutputFile;

import static controller.common_pattern.CommandLogger.loggerCom;

public class WriteToTxtCommand extends Command{
    @Override
    public void execute() {
        InputOutputFile.writeToTXT(bookService.getModel(), utility.getPath());
        loggerCom.info(" Menu selected: " + 9 + ". Description: Write to file (.txt)");

    }
}
