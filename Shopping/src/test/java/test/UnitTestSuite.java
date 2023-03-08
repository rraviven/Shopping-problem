package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    test.SampleUnitTest.class,
    test.HiddenUnitTest.class
})

public class UnitTestSuite { 
}
