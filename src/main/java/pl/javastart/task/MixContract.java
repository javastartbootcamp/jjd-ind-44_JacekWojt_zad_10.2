package pl.javastart.task;

public class MixContract extends PhoneContract {
    private int smsSent;
    private int mmsSent;
    private int secondsCall;

    private int smsLimit;
    private int mmsLimit;
    private double callLimit;

    public MixContract(double accountBalance, double smsCost, double mmsCost, double callCost, int smsLimit,
                       int mmsLimit, double callLimit) {
        super(accountBalance, smsCost, mmsCost, callCost);
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.callLimit = callLimit;
    }

    public int getSmsLimit() {
        return smsLimit;
    }

    public void setSmsLimit(int smsLimit) {
        this.smsLimit = smsLimit;
    }

    public int getMmsLimit() {
        return mmsLimit;
    }

    public void setMmsLimit(int mmsLimit) {
        this.mmsLimit = mmsLimit;
    }

    public double getCallLimit() {
        return callLimit;
    }

    public void setCallLimit(double callLimit) {
        this.callLimit = callLimit;
    }

    @Override
    public void sendSms() {
        if (getSmsLimit() - smsSent >= 0) {
            smsSent++;
            System.out.println("SMS wysłany\n");
        } else if (getAccountBalance() - getSmsCost() > 0) {
            setAccountBalance(getAccountBalance() - getSmsCost());
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. SMS nie został wysłany!\n");
        }
    }

    @Override
    public void sendMms() {
        if (getMmsLimit() - mmsSent >= 0) {
            mmsSent++;
            setMmsLimit(getMmsLimit() - 1);
            System.out.println("MMS wysłany\n");
        } else if (getAccountBalance() - getMmsCost() > 0) {
            setAccountBalance(getAccountBalance() - getMmsCost());
            System.out.println("MMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. MMS nie został wysłany!\n");
        }
    }

    @Override
    public void call(int seconds) {
        if (getCallLimit() - seconds >= 0) {
            secondsCall += seconds;
            setCallLimit(getCallLimit() - seconds);
            System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
        } else if (getAccountBalance() - (getCallCost() / 60) * seconds >= 0) {
            secondsCall += seconds;
            setAccountBalance(getAccountBalance() - (getCallCost() / 60) * seconds);
            System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
        } else {
            System.out.println("Brak środków na koncie. Rozmowa niemożliwa!\n");
        }
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENT MIX=====" +
                "\nWysłanych SMSów: " + smsSent +
                "\nPozostałych SMSów: " + getSmsLimit() +
                "\nWysłanych MMSów: " + mmsSent +
                "\nPozostałych MMSów: " + getMmsLimit() +
                "\nLiczba sekund rozmowy: " + secondsCall +
                "\nNa koncie pozostalo " + getAccountBalance() + "\n");
    }
}
