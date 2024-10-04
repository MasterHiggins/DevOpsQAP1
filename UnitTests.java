import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("12345");
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("12345");
        account.deposit(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("12345");
        account.deposit(50);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100));
    }
}
