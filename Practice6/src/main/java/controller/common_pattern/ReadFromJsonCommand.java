package controller.common_pattern;

import utility.InputOutputFile;

import static controller.common_pattern.CommandLogger.loggerCom;

public class ReadFromJsonCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: " + 7 + ". Description: Read from file(.json) and set to model");
        bookService.setBooks(InputOutputFile.readFromJSON(utility.getPath()));

    }
}
