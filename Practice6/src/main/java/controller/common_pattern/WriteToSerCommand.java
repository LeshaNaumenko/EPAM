package controller.common_pattern;

import utility.InputOutputFile;

import static controller.common_pattern.CommandLogger.loggerCom;

public class WriteToSerCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: " + 8 + ". Description: Write to file (.ser)");

        InputOutputFile.writeToFileSer(bookService.getModel(), utility.getPath());
//
    }
}
