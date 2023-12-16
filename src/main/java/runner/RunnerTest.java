package runner;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import tests.BlogTest;

@SelectClasses({BlogTest.class})
@Suite
@SuiteDisplayName("Todos os testes")
public class RunnerTest {
}
