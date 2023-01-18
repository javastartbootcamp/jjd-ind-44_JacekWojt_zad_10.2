package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
//        Phone card = new Phone(new CardContract(5.0, 0.5, 1.5, 2.0));
//        card.printAccountState();
//        card.call(60);
//        card.sendSms();
//        card.sendSms();
//        card.sendMms();
//        card.printAccountState();
//
//        Phone monthly = new Phone(new MonthlyContract(45));
//        monthly.printAccountState();
//        monthly.sendSms();
//        monthly.sendSms();
//        monthly.sendMms();
//        monthly.call(360);
//        monthly.printAccountState();

        Phone mix = new Phone(new MixContract(2.0, 0.5, 1.0, 2.0, 2, 2, 180));
        mix.printAccountState();
        mix.call(120);
        mix.call(60);
        mix.printAccountState();
        mix.call(30);
        mix.printAccountState();
        mix.call(60);
        mix.printAccountState();
        mix.call(60);
        mix.printAccountState();
    }
}

