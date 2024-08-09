package br.com.passos.interfaces;

import br.com.passos.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);

}
