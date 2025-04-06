# Minecraft RCON MCP Server

A Spring Boot application that provides a bridge between Model Context Protocol (MCP) and a Minecraft server's RCON interface, allowing AI models to send commands to a Minecraft server. Built with SpringAI.

## Description

This project enables AI models using Spring AI's MCP functionality to interact with a Minecraft server through the RCON protocol. It provides a simple tool that can send commands to the Minecraft server and receive responses, making it possible for AI models to control and query the Minecraft server.

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- A Minecraft server with RCON enabled

## Building the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/minecraft-rcon-mcp.git
   cd minecraft-rcon-mcp
   ```

2. Build the project using Maven:
   ```bash
   ./mvnw clean package
   ```
   
   On Windows:
   ```bash
   mvnw.cmd clean package
   ```

3. The built JAR file will be located in the `target` directory:
   ```
   target/minecraft-rcon-mcp-1.0.0.jar
   ```

## Configuration

The application can be configured using environment variables or a `.env` file in the project root directory.

### Required Env Param Configuration

- `RCON_HOST`: The hostname or IP address of the Minecraft server (default: `localhost`)
- `RCON_PORT`: The RCON port of the Minecraft server (default: `25575`)
- `RCON_PASSWORD`: The RCON password for authentication (required, no default)

### Optional Configuration

- `logging.file.name`: The name of the log file (default: `rconmcp.log`)

## Usage

Once the application is built and added to an MCP Client with your Env-Params, it exposes a Model Context Protocol (MCP) server that can be used by Spring AI clients to send commands to the Minecraft server.

The MCP server provides a tool called `sendCommand` that takes a Minecraft command as input and returns the response from the server.

## License

[MIT License](https://opensource.org/licenses/MIT)
