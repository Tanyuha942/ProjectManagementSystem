package com.goit;

import java.sql.*;
import org.apache.logging.log4j.*;
import com.goit.config.DataSourceHolder;

public class PrintInfoToConsole {

  private static final Logger LOGGER = LogManager.getLogger(PrintInfoToConsole.class);

  public static void sumSalaryDevelopersOfProject(String name) throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement
        .executeQuery("SELECT p.project_name,\n"
            + "    sum(d.salary) AS sum_salary\n"
            + "   FROM developers d\n"
            + "     JOIN developer_project dp ON dp.developer_id = d.id\n"
            + "     JOIN projects p ON p.id = dp.project_id\n"
            + "where p.project_name = '"
            + name + "' GROUP BY p.project_name;");

      while (resultSet.next()) {
        LOGGER.info("--========================================================================--");
        LOGGER.info("Проект: " + resultSet.getString(1) +
            " | Зарплата всех разработчиков: " + resultSet.getString(2));
        LOGGER.info("--========================================================================--");
      }
      connection.close();
  }

  public static void listDevelopersOfProject(String name) throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement
        .executeQuery("select d.last_name || ' ' || d.first_name || ' ' || d.surname as developer_name\n"
            + "from projects p\n"
            + "join developer_project dp on dp.project_id = p.id\n"
            + "join developers d on dp.developer_id = d.id\n"
            + "where p.project_name = '" + name + "';");
    LOGGER.info("--========================================================================--");
    while (resultSet.next()) {
      LOGGER.info("ФИО разработчика: " + resultSet.getString(1));
    }
    LOGGER.info("--========================================================================--");
    connection.close();
  }

  public static void listOfJavaDevelopers() throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement
        .executeQuery("select d.last_name || ' ' || d.first_name || ' ' || d.surname as developer_name\n"
            + "from skills s\n"
            + "join developer_skill ds on ds.skill_id = s.id\n"
            + "join developers d on d.id = ds.developer_id \n"
            + "where s.industry = 'Java';");
    LOGGER.info("--========================================================================--");
    while (resultSet.next()) {
      LOGGER.info("Java developer: " + resultSet.getString(1));
    }
    LOGGER.info("--========================================================================--");
    connection.close();
  }

  public static void listOfMiddleDevelopers() throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement
        .executeQuery("select d.last_name || ' ' || d.first_name || ' ' || d.surname as developer_name\n"
            + "from skills s\n"
            + "join developer_skill ds on ds.skill_id = s.id\n"
            + "join developers d on d.id = ds.developer_id \n"
            + "where s.level_skills = 'Middle';");
    LOGGER.info("--========================================================================--");
    while (resultSet.next()) {
      LOGGER.info("Middle developer: " + resultSet.getString(1));
    }
    LOGGER.info("--========================================================================--");
    connection.close();
  }

  public static void listOfProjects() throws SQLException {

    Connection connection = DataSourceHolder.getDataSource().getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement
        .executeQuery("select"
            + " p.created || ' - ' || p.project_name || ' - ' || count(dp.developer_id) as list_projects\n"
            + "from projects p\n"
            + "join developer_project dp on dp.project_id = p.id\n"
            + "group by created, project_name;");
    LOGGER.info("--========================================================================--");
    while (resultSet.next()) {
      LOGGER.info("Проект: " + resultSet.getString(1));
    }
    LOGGER.info("--========================================================================--");
    connection.close();
  }
}