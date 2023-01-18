package pl.javastart.task;

public class MixContract extends CardContract {
    private int smsLimit;
    private int mmsLimit;
    private int callLimit;

    public MixContract(double accountBalance, double smsCost, double mmsCost, double callCost, int smsLimit,
                       int mmsLimit, int callLimit) {
        super(accountBalance, smsCost, mmsCost, callCost);
        this.smsLimit = smsLimit;
        this.mmsLimit = mmsLimit;
        this.callLimit = callLimit;
    }

    @Override
    public void sendSms() {
        if (smsLimit > 0) {
            setSmsSent(getSmsSent() + 1);
            smsLimit--;
            System.out.println("SMS wysłany\n");
        } else if (getAccountBalance() - getSmsCost() >= 0) {
            setAccountBalance(getAccountBalance() - getSmsCost());
            setSmsSent(getSmsSent() + 1);
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. SMS nie został wysłany!\n");
        }
    }

    @Override
    public void sendMms() {
        if (mmsLimit > 0) {
            setMmsSent(getMmsSent() + 1);
            mmsLimit--;
            System.out.println("MMS wysłany\n");
        } else if (getAccountBalance() - getMmsCost() >= 0) {
            setAccountBalance(getAccountBalance() - getMmsCost());
            setMmsSent(getMmsSent() + 1);
            System.out.println("MMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. MMS nie został wysłany!\n");
        }
    }

    @Override
    public void call(int seconds) {
        if (callLimit >= seconds) {
            setSecondsCall(getSecondsCall() + seconds);
            callLimit -= seconds;
            System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
        } else if (seconds <= callLimit + (getAccountBalance() / getCallCost()) * 60) {
            setSecondsCall(getSecondsCall() + seconds);
            setAccountBalance(getAccountBalance() - (getCallCost() / 60) * (seconds - callLimit));
            System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
            callLimit = 0;
        } else if (seconds > callLimit + (getAccountBalance() / getCallCost()) * 60 && getAccountBalance() != 0) {
            setSecondsCall(getSecondsCall() + (int) ((callLimit + (getAccountBalance() / getCallCost()) * 60)));
            System.out.println("Rozmowa trwała: " + ((getAccountBalance() / getCallCost()) * 60) + " sekund., "
                    + "po czym została przerwana z powodu braku środków.\n");
            setAccountBalance(0.0);
        } else {
            System.out.println("Brak środków na koncie\n");
        }
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENT MIX=====" +
                "\nWysłanych SMSów: " + getSmsSent() +
                "\nPozostałych SMSów: " + smsLimit +
                "\nWysłanych MMSów: " + getMmsSent() +
                "\nPozostałych MMSów: " + mmsLimit +
                "\nLiczba sekund rozmów: " + getSecondsCall() +
                "\nPozostałych sekund: " + callLimit +
                "\nNa koncie pozostało " + getAccountBalance() + "\n");
    }
}
