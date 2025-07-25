package service;

/**
 *  Interface to read user-provide data
 */

public interface ITerminal {
    /**
     * To write message for the user
     * @param message
     */
    void showMessage(String message);

    /**
     * To read input message by user
     * @return
     */

    String readLine();

    /**
     * To read input number by user
     * @return
     */

    int readLineAsInt();

    /**
     * To read input double number by user
     * @return
     */

    double readLineAsDouble();
}
