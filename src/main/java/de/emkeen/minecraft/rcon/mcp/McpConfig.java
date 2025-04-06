package de.emkeen.minecraft.rcon.mcp;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.glavo.rcon.AuthenticationException;
import org.glavo.rcon.Rcon;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class McpConfig {
  
  @Value("${rcon.host}")
  private String rconHost;
  @Value("${rcon.port}")
  private int rconPort;
  @Value("${rcon.password}")
  private String rconPassword;
  

  @Bean
  public ToolCallbackProvider myTools(RconService rconService) {
    return MethodToolCallbackProvider.builder().toolObjects(rconService).build();
  }

  @Bean
  @Profile("!test")
  public Rcon rcon() throws AuthenticationException, IOException {
    return new Rcon(rconHost, rconPort, rconPassword);
  }
}
