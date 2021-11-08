package com.goit;

import com.goit.config.DbMigration;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.logging.log4j.*;
import com.goit.console.CommandHandler;
import java.util.Scanner;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws SQLException, ParseException {
        LOGGER.debug("Start application");
        DbMigration.migrate();

        runMainApp();
        LOGGER.info("END application");
    }

    public static void runMainApp() throws SQLException, ParseException {

        CommandHandler commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            commandHandler.handleCommand(scanner.nextLine());
        }
    }
}