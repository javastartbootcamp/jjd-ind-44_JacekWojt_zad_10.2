package pl.javastart.task;

public abstract class PhoneContract implements Phone {
    private double accountBalance;
    private double smsCost;
    private double mmsCost;
    private double callCost;

    public PhoneContract(double accountBalance, double smsCost, double mmsCost, double callCost) {
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
    public abstract void sendSms();

    @Override
    public abstract void sendMms();

    @Override
    public abstract void call(int seconds);

    @Override
    public abstract void printAccountState();
}
