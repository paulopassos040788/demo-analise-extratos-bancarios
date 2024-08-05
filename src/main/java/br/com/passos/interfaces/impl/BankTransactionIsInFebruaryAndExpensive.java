package br.com.passos.interfaces.impl;

import br.com.passos.BankTransaction;
import br.com.passos.interfaces.BankTransactionFilter;
import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1000;
    }

}
