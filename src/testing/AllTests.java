package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        TestAppointment.class,
        TestCustomer.class,
        TestPerson.class,
        TestService.class,
        TestWorker.class,
        TestBarbershop.class,
        TestManager.class })

public class AllTests {

}