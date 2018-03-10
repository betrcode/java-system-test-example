package se.bettercode.systemtest.testutils;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.bettercode.systemtest.config.Config;

import java.io.IOException;

@Getter
public class TestSetup {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestSetup.class);

  private Config config;

  public TestSetup() {
    try {
      config = ConfigLoader.load();
      LOGGER.info("Config loaded");
    } catch (IOException e) {
      LOGGER.warn("Could not load config file", e);
    }
  }
}
