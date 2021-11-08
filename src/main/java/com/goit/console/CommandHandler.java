package com.goit.console;

import static com.goit.console.Command.pattern;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import org.apache.logging.log4j.*;

public class CommandHandler {

    private static final Logger LOGGER = LogManager.getLogger(CommandHandler.class);

    Command mainMenu = new MainMenuCommand();
    Command activeMenu = mainMenu;

    public CommandHandler() {
        this.activeMenu.printActiveMenu();
    }

//    Map<String, Command> commandMap = new HashMap<>();

//    public CommandHandler() {
//        commandMap.put("companies", new CompaniesCommand());
//        commandMap.put("developers", new DevelopersCommand());
////        commandMap.put("items", new ItemsCommand());
//    }

//    public void handleCommand(String params) throws ParseException {
//        int firstSpace = params.indexOf(" ");
//        if (firstSpace > -1) {
//            Command command = commandMap
//                    .getParams(params.substring(0, firstSpace));
//            if (command != null) {
//                command.handle(params.substring(firstSpace + 1));
//            } else {
//                System.out.println("Unknown command");
//            }
//        } else {
//            System.out.println("Unknown command");
//        }
//    }

    public void handleCommand(String params) throws ParseException, SQLException {

        Matcher matcher = pattern.matcher(params);
        if (matcher.find()) {
            String command = matcher.group();
            if ("exit".equalsIgnoreCase(command)) {
                System.exit(0);
            } else if ("active".equalsIgnoreCase(command)) {
                this.activeMenu.printActiveMenu();
            } else if ("main".equalsIgnoreCase(command)) {
                this.activeMenu = mainMenu;
                this.activeMenu.printActiveMenu();
            } else {
                this.activeMenu.handle(params, cm -> {
                    this.activeMenu = cm;
                    this.activeMenu.printActiveMenu();
                });
            }
        }
        else {
            LOGGER.warn("Empty command");
        }
    }
}
