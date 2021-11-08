package com.goit.console.commands;

import com.goit.config.DataSourceHolder;
import com.goit.console.Command;
import java.sql.*;
import java.text.ParseException;
import java.util.function.Consumer;
import org.apache.logging.log4j.*;

public class PrintInfoToConsoleCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(PrintInfoToConsoleCommand.class);

  @Override
  public void handle(String params, Consumer<Command> setActive) throws ParseException, SQLException {
    String[] paramsArray = params.split(" ");
    String subParams = String.join(" ", params.replace(paramsArray[0]+ " ", ""));

    switch (paramsArray[0]) {
      case "getSumProjectSalary" : getSumProjectSalary(subParams); break;
      case "getProjectDevelopers": getProjectDevelopers(subParams); break;
      case "getJavaDevelopers"   : getJavaDevelopers(); break;
      case "getMiddleDevelopers" : getMiddleDevelopers(); break;
      case "projectsInfo"        : projectsInfo(); break;

    }
  }

  private void getSumProjectSalary(String params) throws SQLException {
    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement
        .executeQuery("select * \n"
            + "from sum_salary_developers_of_project\n"
            + "where project_name = '"
            + params + "';");

    while (resultSet.next()) {
      LOGGER.info("Project: " + resultSet.getString(1) +
          " " + "Sum salary: " + resultSet.getString(2));
    }
    connection.close();
  }

  private void getProjectDevelopers(String params) throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement
        .executeQuery("select project_name, developer_name\n"
            + "from list_developers_of_project\n"
            + "where project_name = '" + params + "';");

    while (resultSet.next()) {
      LOGGER.info("Developer name: " + resultSet.getString(2));
    }
    connection.close();
  }

  public static void getJavaDevelopers() throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from list_of_java_developers;");
    while (resultSet.next()) {
      LOGGER.info("Java developer: " + resultSet.getString(1));
    }
    connection.close();
  }

  public static void getMiddleDevelopers() throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from list_of_middle_developers;");
    while (resultSet.next()) {
      LOGGER.info("Middle developer: " + resultSet.getString(1));
    }
    connection.close();
  }

  public static void projectsInfo() throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from list_of_projects;");
    while (resultSet.next()) {
      LOGGER.info("Project: " + resultSet.getString(1));
    }
    connection.close();
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------PrintInfo menu---------------------");
    LOGGER.info("1. Зарплата(сумма) всех разработчиков отдельного проекта:");
    LOGGER.info("\t getSumProjectSalary [project_name]");
    LOGGER.info("2. Список разработчиков отдельного проекта:");
    LOGGER.info("\t getProjectDevelopers [project_name]");
    LOGGER.info("3. Список всех Java разработчиков:");
    LOGGER.info("\t getJavaDevelopers");
    LOGGER.info("4. Список всех middle разработчиков:");
    LOGGER.info("\t getMiddleDevelopers");
    LOGGER.info("5. Список проектов в следующем формате:\n"
        + "дата создания - название проекта - количество разработчиков на этом проекте:");
    LOGGER.info("\t projectsInfo");
  }
}