package de.emkeen.minecraft.rcon.mcp;

import org.glavo.rcon.Rcon;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Configuration
@Profile("test")
public class TestConfig {
  @Bean
  public Rcon rcon() {
    Rcon mockRcon = Mockito.mock(Rcon.class);
    try {
      // Configure the mock to return a default response for any command
      Mockito.when(mockRcon.command(Mockito.anyString())).thenReturn("Mock RCON response");
    } catch (IOException e) {
      // This won't happen with a mock, but we need to handle the exception
      // that the real method would throw
    }
    return mockRcon;
  }
}
