package pl.javastart.task;

import pl.javastart.task.phone.CardContract;
import pl.javastart.task.phone.MixContract;
import pl.javastart.task.phone.MonthlyContract;
import pl.javastart.task.phone.Phone;

public class Main {

    public static void main(String[] args) {
        Phone card = new Phone(new CardContract(1.5, 0.5, 1.5, 0.5));
        card.printAccountState();
        card.call(120);
        card.printAccountState();
        card.call(120);
        card.printAccountState();
        card.call(60);
        card.printAccountState();

        Phone monthly = new Phone(new MonthlyContract(45));
        monthly.printAccountState();
        monthly.sendSms();
        monthly.sendSms();
        monthly.sendMms();
        monthly.call(360);
        monthly.printAccountState();

        Phone mix = new Phone(new MixContract(2.0, 0.5, 1.0, 2.0, 2, 2, 180));
        mix.printAccountState();
        mix.call(60);
        mix.printAccountState();
    }
}

