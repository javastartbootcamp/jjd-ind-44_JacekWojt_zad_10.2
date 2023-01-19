package pl.javastart.task.phone;

public class CardContract extends PhoneContract {
    double accountBalance;
    double smsCost;
    double mmsCost;
    double callCost;

    public CardContract(double accountBalance, double smsCost, double mmsCost, double callCost) {
        this.accountBalance = accountBalance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.callCost = callCost;
    }

    @Override
    public void sendSms() {
        if (accountBalance >= smsCost) {
            accountBalance -= smsCost;
            smsSent++;
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. SMS nie został wysłany!\n");
        }
    }

    @Override
    public void sendMms() {
        if (accountBalance >= mmsCost) {
            accountBalance -= mmsCost;
            mmsSent++;
            System.out.println("MMS wysłany\n");
        } else {
            System.out.println("Brak środków na koncie. MMS nie został wysłany!\n");
        }
    }

    @Override
    public void call(int seconds) {
        if (accountBalance >= (callCost / 60) * seconds) {
            accountBalance -= ((callCost / 60) * seconds);
            secondsCall += seconds;
            System.out.println("Czas wykonanej rozmowy: " + seconds + " sekund\n");
        } else if (accountBalance < (callCost / 60) * seconds && accountBalance > 0) {
            secondsCall += (accountBalance / callCost) * 60;
            System.out.println("Rozmowa trwała " + ((accountBalance / callCost) * 60) + " sekund," +
                    " po czym została przerwana z powodu braku środków.\n");
            accountBalance = 0;
        } else {
            System.out.println("Brak środków na koncie. Rozmowa niemożliwa!\n");
        }
    }

    @Override
    public void printAccountState() {
        System.out.println("=====STAN KONTA ABONAMENTU NA KARTĘ=====" +
                "\nWysłanych SMSów: " + smsSent +
                "\nWysłanych MMSów: " + mmsSent +
                "\nLiczba sekund rozmów: " + secondsCall +
                "\nNa koncie pozostało " + accountBalance + "\n");
    }
}
