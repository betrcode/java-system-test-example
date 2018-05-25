package se.bettercode.systemtest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.bettercode.systemtest.suite.FirstTestSuite;
import se.bettercode.systemtest.testutils.TestSetup;

import static org.hamcrest.Matchers.notNullValue;

public class ExampleTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleTest.class);
  private static final TestSetup SETUP = FirstTestSuite.SETUP;
  private static final String URL_FORMAT = "http://%s:%s/get";

  private String url;

  @Before
  public void setUp() {
    RestAssured.registerParser("application/octet-stream", Parser.JSON);
    url = String.format(URL_FORMAT, SETUP.getConfig().getHostname(), SETUP.getConfig().getPort());
    LOGGER.info("Testing: {}", url);
  }

  @Test
  public void restEndpointIsOK() {
    RestAssured.given()
        .when()
        .get(url)
        .then()
        .statusCode(200)
        .body("origin", notNullValue())
        .body("url", notNullValue());
  }
}
