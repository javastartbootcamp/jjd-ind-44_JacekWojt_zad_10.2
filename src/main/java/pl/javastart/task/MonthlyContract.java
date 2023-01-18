package pl.javastart.task;

public class MonthlyContract extends PhoneContract {
    private double monthlyCost;

    public MonthlyContract(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public void sendSms() {
        setSmsSent(getSmsSent() + 1);
        System.out.println("SMS wysłany\n");
    }

    @Override
    public void sendMms() {
        setMmsSent(getMmsSent() + 1);
        System.out.println("MMS wysłany\n");
    }

    @Override
    public void call(int seconds) {
        setSecondsCall(getSecondsCall() + seconds);
        System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENT MIESIĘCZNY=====" +
                "\nWysłanych SMSów: " + getSmsSent() +
                "\nWysłanych MMsów: " + getMmsSent() +
                "\nLiczba sekund rozmów: " + getSecondsCall() +
                "\nMiesięczna opłata: " + monthlyCost + "\n");
    }
}
