package pl.javastart.task.phone;

public abstract class PhoneContract {
    int smsSent;
    int mmsSent;
    int secondsCall;

    public abstract void sendSms();

    public abstract void sendMms();

    public abstract void call(int seconds);

    public abstract void printAccountState();
}
