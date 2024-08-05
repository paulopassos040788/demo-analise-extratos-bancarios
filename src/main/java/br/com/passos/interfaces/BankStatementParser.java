package br.com.passos.interfaces;

import br.com.passos.BankTransaction;

import java.util.List;

public interface BankStatementParser {

    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
