package project1_mobile_service.view;

/**
 * {@code FindMenu} interface contains find menu messages for search to inform the user
 *
 * @author Alex Naumenko
 * @version 1.0
 */

public interface FindMenu {

    /**
     * Strings that represents message 'BY_NAME'.
     */
    String BY_NAME =        "\t\t> \'=\'  name                                 -         press 1\n";

    /**
     * Strings that represents message 'DELETE_NAME'.
     */
    String DELETE_NAME =    "\t\t> \'!=\' name                                 -         press 2\n";

    /**
     * Strings that represents message 'FEE'.
     */
    String FEE =            "\t\t> \'=\'  subscription fee                     -         press 3\n";

    /**
     * Strings that represents message 'MORE_FEE'.
     */
    String MORE_FEE =       "\t\t> \'>\'  the specified subscription fee       -         press 4\n";

    /**
     * Strings that represents message 'LESS_FEE'.
     */
    String LESS_FEE =       "\t\t> \'<\'  the specified subscription fee       -         press 5\n";

    /**
     * Strings that represents message 'HAS_INTERNET'.
     */
    String HAS_INTERNET=    "\t\t> \'+\'  internet                             -         press 6\n";

    /**
     * Strings that represents message 'HAS_NO_INTERNET'.
     */
    String HAS_NO_INTERNET= "\t\t> \'-\'  internet                             -         press 7\n";

    /**
     * Strings that represents message 'BACK_TO_MENU'.
     */
    String BACK_TO_MENU=    "\t\t> Back to menu                              -         press 0\n";
}
