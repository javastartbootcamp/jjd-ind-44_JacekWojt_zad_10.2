package pl.javastart.task;

public class CardContract extends PhoneContract {
    private double accountBalance;
    private double smsCost;
    private double mmsCost;
    private double callCost;

    public CardContract(double accountBalance, double smsCost, double mmsCost, double callCost) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callCost = callCost;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public double getMmsCost() {
        return mmsCost;
    }

    public void setMmsCost(double mmsCost) {
        this.mmsCost = mmsCost;
    }

    public double getCallCost() {
        return callCost;
    }

    public void setCallCost(double callCost) {
        this.callCost = callCost;
    }

    @Override
    public void sendSms() {
        if (!(accountBalance - smsCost < 0)) {
            accountBalance -= smsCost;
            setSmsSent(getSmsSent() + 1);
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. SMS nie został wysłany!\n");
        }
    }

    @Override
    public void sendMms() {
        if (!(accountBalance - mmsCost < 0)) {
            accountBalance -= mmsCost;
            setMmsSent(getMmsSent() + 1);
            System.out.println("MMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. MMS nie został wysłany!\n");
        }
    }

    @Override
    public void call(int seconds) {
        if (!(accountBalance - (callCost / 60) * seconds < 0)) {
            accountBalance -= ((callCost / 60) * seconds);
            setSecondsCall(getSecondsCall() + seconds);
            System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
        } else {
            System.out.println("Brak środków na koncie. MMS nie został wysłany!\n");
        }
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENTU NA KARTĘ=====" +
                "\nWysłanych SMSów: " + getSmsSent() +
                "\nWysłanych MMSów: " + getMmsSent() +
                "\nLiczba sekund rozmów: " + getSecondsCall() +
                "\nNa koncie pozostało " + accountBalance + "\n");
    }
}
