package controller.common_pattern;

import controller.service.Service;
import utility.InputOutputFile;

import static controller.common_pattern.CommandLogger.loggerCom;

public class ReadFromTxtCommand extends Command{
    @Override
    public void execute() {
        loggerCom.info(" Menu selected: " + 6 + ". Description: Read from file(.txt) and set to model");
        bookService.setBooks(Service.createBooks(InputOutputFile.readFromTXT(utility.getPath())));

    }
}
