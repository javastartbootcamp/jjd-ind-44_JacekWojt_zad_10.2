package pl.javastart.task;

public abstract class PhoneContract {
    private int smsSent;
    private int mmsSent;
    private int secondsCall;

    public int getSmsSent() {
        return smsSent;
    }

    public void setSmsSent(int smsSent) {
        this.smsSent = smsSent;
    }

    public int getMmsSent() {
        return mmsSent;
    }

    public void setMmsSent(int mmsSent) {
        this.mmsSent = mmsSent;
    }

    public int getSecondsCall() {
        return secondsCall;
    }

    public void setSecondsCall(int secondsCall) {
        this.secondsCall = secondsCall;
    }

    public abstract void sendSms();

    public abstract void sendMms();

    public abstract void call(int seconds);

    public abstract void printAccountState();
}
