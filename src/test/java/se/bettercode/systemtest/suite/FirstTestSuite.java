package se.bettercode.systemtest.suite;

import se.bettercode.systemtest.ExampleTest;
import se.bettercode.systemtest.testutils.TestSetup;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ExampleTest.class
})

public class FirstTestSuite {
  public static final TestSetup SETUP = new TestSetup();
}
