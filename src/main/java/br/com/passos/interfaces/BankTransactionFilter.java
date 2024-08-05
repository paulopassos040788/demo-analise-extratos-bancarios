package br.com.passos.interfaces;

import br.com.passos.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);

}
