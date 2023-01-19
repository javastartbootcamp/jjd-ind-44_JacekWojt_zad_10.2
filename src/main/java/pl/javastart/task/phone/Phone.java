package pl.javastart.task.phone;

public class Phone {
    private PhoneContract contract;

    public Phone(PhoneContract contract) {
        this.contract = contract;
    }

    public PhoneContract getContract() {
        return contract;
    }

    public void setContract(PhoneContract contract) {
        this.contract = contract;
    }

    public void sendSms() {
        contract.sendSms();
    }

    public void sendMms() {
        contract.sendMms();
    }

    public void call(int seconds) {
        contract.call(seconds);
    }

    public void printAccountState() {
        contract.printAccountState();
    }
}
