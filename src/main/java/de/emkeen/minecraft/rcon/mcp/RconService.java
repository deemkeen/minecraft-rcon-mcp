package de.emkeen.minecraft.rcon.mcp;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.glavo.rcon.Rcon;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RconService {

  private final Rcon rcon;

  @Tool(description = "sends a command to a minecraft rcon server and gets a response")
  public String sendCommand(String command) {
    try {
      return rcon.command(command);
    } catch (IOException e) {
      return "Error sending command: " + e.getMessage();
    }
  }
}
