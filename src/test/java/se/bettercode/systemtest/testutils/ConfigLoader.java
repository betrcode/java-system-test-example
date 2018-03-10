package se.bettercode.systemtest.testutils;

import lombok.val;
import se.bettercode.systemtest.config.Config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;

public class ConfigLoader {
  public static Config load() throws IOException {
    val configFile = System.getProperty("configFile");
    if (configFile == null) {
      throw new RuntimeException("No system property 'configFile' specified. Specify it. The value should be the path to the config file.");
    }
    return new Yaml().loadAs(new FileInputStream(configFile), Config.class);
  }
}
