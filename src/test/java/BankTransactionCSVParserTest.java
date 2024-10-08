import br.com.passos.interfaces.impl.BankStatementCSVParser;
import br.com.passos.interfaces.BankStatementParser;
import br.com.passos.BankTransaction;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;

public class BankTransactionCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void deveAnalisarUmaLinhaCorreta() throws Exception {
        String line = "30-01-2017,-50,Tesco";

        BankTransaction result = statementParser.parseFrom(line);

        BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}
