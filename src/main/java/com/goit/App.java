package com.goit;

import com.goit.config.DbMigration;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.logging.log4j.*;
import com.goit.console.CommandHandler;
import java.util.Scanner;

public class App {

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws ParseException {
        LOGGER.debug("Start application");
        DbMigration.migrate();

        runMainApp();
        LOGGER.info("END application");
    }

    public static void runMainApp() throws ParseException {
        LOGGER.info("вывести на консоль:");
        LOGGER.info("1. Зарплату(сумму) всех разработчиков отдельного проекта:");
        try {
            PrintInfoToConsole.sumSalaryDevelopersOfProject("Проект2");
        } catch (SQLException sq) {
            LOGGER.error(sq);
        }
        LOGGER.info("2. Список разработчиков отдельного проекта:");
        try {
            PrintInfoToConsole.listDevelopersOfProject("Проект3");
        } catch (SQLException sq) {
            LOGGER.error(sq);
        }
        LOGGER.info("3. Список всех Java разработчиков:");
        try {
            PrintInfoToConsole.listOfJavaDevelopers();
        } catch (SQLException sq) {
            LOGGER.error(sq);
        }
        LOGGER.info("4. Список всех middle разработчиков:");
        try {
            PrintInfoToConsole.listOfMiddleDevelopers();
        } catch (SQLException sq) {
            LOGGER.error(sq);
        }
        LOGGER.info("5. Список проектов в следующем формате:\n"
            + "дата создания - название проекта - количество разработчиков на этом проекте:");
        try {
            PrintInfoToConsole.listOfProjects();
        } catch (SQLException sq) {
            LOGGER.error(sq);
        }

        CommandHandler commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            commandHandler.handleCommand(scanner.nextLine());
        }
    }
}