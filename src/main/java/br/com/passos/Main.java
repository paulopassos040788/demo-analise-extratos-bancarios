package br.com.passos;

import br.com.passos.interfaces.BankStatementParser;
import br.com.passos.interfaces.impl.BankStatementCSVParser;

public class Main {

    public static void main(String[] args) throws Exception{
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);
    }

}