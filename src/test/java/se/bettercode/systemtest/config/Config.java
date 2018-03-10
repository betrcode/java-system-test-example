package se.bettercode.systemtest.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Config {
  String hostname;
  int port;
  CredentialsConfig database;
}
