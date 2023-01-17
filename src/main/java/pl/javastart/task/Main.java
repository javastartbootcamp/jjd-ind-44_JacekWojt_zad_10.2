package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        PhoneContract card = new CardContract(40.0, 0.5, 1.5, 2.0);
        card.printAccountState();
        card.call(60);
        card.sendSms();
        card.sendSms();
        card.printAccountState();

        MonthlyContract monthly = new MonthlyContract(60);
        monthly.sendSms();
        monthly.sendSms();
        monthly.sendMms();
        monthly.call(380);
        monthly.call(120);
        monthly.printAccountState();

        PhoneContract mix = new MixContract(2.0, 1.0, 1.5, 2.0, 2, 1, 120.0);
        mix.printAccountState();
        mix.call(60);
        mix.call(30);
        mix.call(30);
        mix.call(30);
        mix.call(30);
        mix.printAccountState();
    }
}

