package com.goit.console;

import com.goit.console.commands.*;
import java.text.ParseException;
import java.util.*;
import java.util.function.Consumer;
import org.apache.logging.log4j.*;

public class MainMenuCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(MainMenuCommand.class);

  Map<String, Command> commands = Map.of(
      "developers", new DevelopersCommand(),
      "companies", new CompaniesCommand(),
      "customers", new CustomerCommand(),
      "projects", new ProjectCommand(),
      "skills", new SkillCommand()
  );

  @Override
  public void handle(String params, Consumer<Command> setActive) {
    Optional<String> commandString = getCommandString(params);
    commandString.map(commands::get)
        .ifPresent(command -> {
          try {
            setActive.accept(command);
            command.handle(params.replace(commandString.get(), "").trim(), setActive);
          } catch (ParseException e) {
            LOGGER.error("ParseException error: " + e);
          }
        });
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------Main menu---------------------");
    LOGGER.info("Command list: " + this.commands.keySet());
  }
}
