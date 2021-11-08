package com.goit.console.commands;

import java.sql.Date;
import java.text.*;
import java.util.*;
import java.util.function.Consumer;
import org.apache.logging.log4j.*;
import com.goit.console.Command;
import com.goit.dao.DeveloperDao;
import com.goit.model.Developer;

public class DevelopersCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(DevelopersCommand.class);
  private final DeveloperDao developerDao = new DeveloperDao();
  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

  @Override
  public void handle(String params, Consumer<Command> setActive) throws ParseException {

    String[] paramsArray = params.split(" ");
    String subParams = String.join(" ", params.replace(paramsArray[0]+ " ", ""));
    switch (paramsArray[0]) {
      case "create": create(subParams);break;
      case "get": get(subParams);break;
      case "getAll": getAll();break;
      case "delete": delete(subParams);break;
      case "update": update(subParams);break;
    }
  }

  private void create(String params) throws ParseException {

    String[] paramsArray = params.split(" ");
    Developer developer = new Developer();
    developer.setLastName(paramsArray[0]);
    developer.setFirstName(paramsArray[1]);
    developer.setSurname(paramsArray[2]);
    developer.setDeveloperAge(Integer.parseInt(paramsArray[3]));
    developer.setDateOfBirth(new Date(format.parse(paramsArray[4]).getTime()));
    developer.setGender(paramsArray[5]);
    developer.setCompanyId(Long.parseLong(paramsArray[6]));
    developer.setSalary(Double.parseDouble(paramsArray[7]));
    developerDao.create(developer);
  }

  private void get(String params) {

    String[] paramsArray = params.split(" ");
    Optional<Developer> developer = developerDao
        .get(Long.parseLong(paramsArray[0]));
    if (developer.isPresent()) {
      System.out.println(developer.get());
    } else {
      System.out.println("Developer with id "  + paramsArray[0] + " not found");
    }
  }

  private void getAll() {
    List<Developer> all = developerDao.getAll();
    System.out.println("Returned "+ all.size() + " developers");
    for (Developer developer : all) {
      System.out.println(developer);
    }
  }

  private void delete(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Developer> developer = developerDao
        .get(Long.parseLong(paramsArray[0]));
    if (developer.isPresent()) {
      developerDao.delete(developer.get());
    } else {
      System.out.println("Developer with id "  + paramsArray[0] + " not found");
    }
  }

  private void update(String params) throws ParseException {
    String[] paramsArray = params.split(" ");
    Optional<Developer> optionalDeveloper = developerDao
        .get(Long.parseLong(paramsArray[0]));
    if (optionalDeveloper.isPresent()) {
      Developer developer = optionalDeveloper.get();
      developer.setLastName(paramsArray[1]);
      developer.setFirstName(paramsArray[2]);
      developer.setSurname(paramsArray[3]);
      developer.setDeveloperAge(Integer.parseInt(paramsArray[4]));
      developer.setDateOfBirth(new Date(format.parse(paramsArray[5]).getTime()));
      developer.setGender(paramsArray[6]);
      developer.setCompanyId(Long.parseLong(paramsArray[7]));
      developer.setSalary(Double.parseDouble(paramsArray[8]));
      developerDao.update(developer);
    } else {
      System.out.println("Developer with id "  + paramsArray[0] + " not found");
    }
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------Developers menu---------------------");
    LOGGER.info("Developers command list:");
    LOGGER.info("create [last_name] [first_name] [surname] [age] [birth(format dd-MM-yyyy)] [gender] [company_id] [salary]");
    LOGGER.info("get [id]");
    LOGGER.info("getAll");
    LOGGER.info("update [last_name] [first_name] [surname] [age] [birth(format dd-MM-yyyy)] [gender] [company_id] [salary]");
    LOGGER.info("delete [id]");
  }
}