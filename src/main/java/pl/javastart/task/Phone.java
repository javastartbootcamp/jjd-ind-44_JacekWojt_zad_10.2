package pl.javastart.task;

public interface Phone {
    void sendSms();

    void sendMms();

    void call(int seconds);

    void printAccountState();
}
