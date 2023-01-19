package pl.javastart.task.phone;

public class MixContract extends CardContract {
    int smsLimit;
    int mmsLimit;
    int callLimit;

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
            smsSent++;
            smsLimit--;
            System.out.println("SMS wysłany\n");
        } else {
            super.sendSms();
        }
    }

    @Override
    public void sendMms() {
        if (mmsLimit > 0) {
            mmsSent++;
            mmsLimit--;
            System.out.println("MMS wysłany\n");
        } else {
            super.sendMms();
        }
    }

    @Override
    public void call(int seconds) {
        int remainingSeconds = useCallLimit(seconds);
        if (remainingSeconds > 0) {
            super.call(remainingSeconds);
        }
    }

    int useCallLimit(int sec) {
        int remSec = 0;
        if (callLimit >= sec) {
            secondsCall += sec;
            callLimit -= sec;
            System.out.println("Czas wykonanej rozmowy: " + sec + " sekund\n");
        } else {
            remSec = sec - callLimit;
            secondsCall += callLimit;
            callLimit = 0;
        }
        return remSec;
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENT MIX=====" +
                "\nWysłanych SMSów: " + smsSent +
                "\nPozostałych SMSów: " + smsLimit +
                "\nWysłanych MMSów: " + mmsSent +
                "\nPozostałych MMSów: " + mmsLimit +
                "\nLiczba sekund rozmów: " + secondsCall +
                "\nPozostałych sekund: " + callLimit +
                "\nNa koncie pozostało " + accountBalance + "\n");
    }
}

