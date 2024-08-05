package br.com.passos;

import br.com.passos.interfaces.BankStatementParser;
import br.com.passos.interfaces.impl.BankTransactionIsInFebruaryAndExpensive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("O total de todas as transações é "
                + bankStatementProcessor.calculateTotalAmount());
        System.out.println("O total de transações em janeiro é "
                + bankStatementProcessor.calculateTotalMonth(Month.JANUARY));
        System.out.println("O total de transações em fevereiro é "
                + bankStatementProcessor.calculateTotalMonth(Month.FEBRUARY));
        System.out.println("O salário total recebido é "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));

        System.out.println("Transações de fevereiro acima ou igual 1000 " +bankStatementProcessor.findTransactions(new BankTransactionIsInFebruaryAndExpensive()));
    }

}
