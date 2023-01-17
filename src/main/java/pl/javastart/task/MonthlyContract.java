package pl.javastart.task;

public class MonthlyContract implements Phone {
    private int smsSent;
    private int mmsSent;
    private int secondsCall;

    private double monthlyCost;

    public MonthlyContract(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public void sendSms() {
        smsSent++;
        System.out.println("SMS wysłany\n");
    }

    @Override
    public void sendMms() {
        mmsSent++;
        System.out.println("MMS wysłany\n");
    }

    @Override
    public void call(int seconds) {
        secondsCall += seconds;
        System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENT MIESIĘCZNY=====" +
                "\nWysłanych SMSów: " + smsSent +
                "\nWysłanych MMsów: " + mmsSent +
                "\nLiczba sekund rozmowy: " + secondsCall +
                "\nMiesięczna opłata: " + getMonthlyCost() + "\n");
    }
}
