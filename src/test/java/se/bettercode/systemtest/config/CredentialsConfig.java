package se.bettercode.systemtest.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsConfig {
  private String hostname;
  private String username;
  private String password;
}
