package C04Interface.BankProgram;

public interface BankServiceInterface {

    void deposit(long money, BankAccount ba);

    boolean withdraw(long money, BankAccount ba);
}
