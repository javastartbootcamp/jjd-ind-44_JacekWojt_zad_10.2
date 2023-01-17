package pl.javastart.task;

public class CardContract extends PhoneContract {
    private int smsSent;
    private int mmsSent;
    private int secondsCall;

    public CardContract(double accountBalance, double smsCost, double mmsCost, double callCost) {
        super(accountBalance, smsCost, mmsCost, callCost);
    }

    @Override
    public void sendSms() {
        if (!(getAccountBalance() - getSmsCost() < 0)) {
            setAccountBalance(getAccountBalance() - getSmsCost());
            smsSent++;
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. SMS nie został wysłany!\n");
        }
    }

    @Override
    public void sendMms() {
        setAccountBalance(getAccountBalance() - getMmsCost());
        mmsSent++;
        System.out.println("MMS wysłany\n");
    }

    @Override
    public void call(int seconds) {
        setAccountBalance(getAccountBalance() - (getCallCost() / 60) * seconds);
        secondsCall += seconds;
        System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENTU NA KARTĘ=====" +
                "\nWysłanych SMSów: " + smsSent +
                "\nWysłanych MMSów: " + mmsSent +
                "\nLiczba sekund rozmowy: " + secondsCall +
                "\nNa koncie pozostalo " + getAccountBalance() + "\n");
    }
}
