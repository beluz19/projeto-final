package service;

public interface ITerminal {
    void showMessage(String message);

    String readLine();

    int readLineAsInt();

    double readLineAsDouble();
}
