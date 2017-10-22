package io.archel;

import io.archel.bankkata.BankAccount;
import io.archel.bankkata.BankAccountImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountPrintFeature {


    @Mock
    private Writer writer;

    @Test
    public void print_account_statment() {

        BankAccount bankAccount = new BankAccountImpl();

        bankAccount.deposit(1000);
        bankAccount.withdraw(100); // or -100
        bankAccount.deposit(500);
        bankAccount.printStatement();

        InOrder inOrder = inOrder(writer);
        inOrder.verify(writer).print("DATE       | AMOUNT  | BALANCE");
        inOrder.verify(writer).print("10/04/2014 | 500.00  | 1400.00");
        inOrder.verify(writer).print("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(writer).print("01/04/2014 | 1000.00 | 1000.00");
   }
}
