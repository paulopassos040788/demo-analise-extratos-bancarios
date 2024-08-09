package br.com.passos;

import br.com.passos.interfaces.BankTransactionFilter;
import br.com.passos.interfaces.BankTransactionSummarizer;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalMonth(final Month month) {
        return summarizeTransactions(((accumulator, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? accumulator + bankTransaction.getAmount() : accumulator));
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final double amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions){
            if (bankTransactionFilter.test(bankTransaction)){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            totalAmount += bankTransaction.getAmount();
        }
        return totalAmount;
    }

    public double calculateTotalForCategory(final String category) {
        double totalAmount = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)){
                totalAmount += bankTransaction.getAmount();
            }
        }
        return totalAmount;
    }


}
