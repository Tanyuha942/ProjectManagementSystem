package com.goit.console.commands;

import java.sql.Date;
import java.text.*;
import java.util.*;
import java.util.function.Consumer;
import org.apache.logging.log4j.*;
import com.goit.console.Command;
import com.goit.dao.ProjectDao;
import com.goit.model.Project;

public class ProjectCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(ProjectCommand.class);
  private final ProjectDao projectDao = new ProjectDao();
  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

  @Override
  public void handle(String params, Consumer<Command> setActive) throws ParseException {
    String[] paramsArray = params.split(" ");
    String subParams = String.join(" ", params.replace(paramsArray[0]+ " ", ""));
    switch (paramsArray[0]) {
      case "create": create(subParams); break;
      case "get": get(subParams); break;
      case "getAll": getAll(); break;
      case "delete": delete(subParams); break;
      case "update": update(subParams); break;
    }
  }

  private void create(String params) throws ParseException {
    String[] paramsArray = params.split(" ");
    Project project = new Project();
    project.setName(paramsArray[0]);
    project.setCreated(new Date(format.parse(paramsArray[1]).getTime()));
    project.setCost(Double.parseDouble(paramsArray[2]));
    projectDao.create(project);
  }

  private void get(String params) {

    String[] paramsArray = params.split(" ");
    Optional<Project> project = projectDao
        .get(Long.parseLong(paramsArray[0]));
    if (project.isPresent()) {
      System.out.println(project.get());
    } else {
      System.out.println("Project with id "  + paramsArray[0] + " not found");
    }
  }

  private void getAll() {
    List<Project> all = projectDao.getAll();
    System.out.println("Returned "+ all.size() + " projects");
    for (Project project : all) {
      System.out.println(project);
    }
  }

  private void delete(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Project> project = projectDao
        .get(Long.parseLong(paramsArray[0]));
    if (project.isPresent()) {
      projectDao.delete(project.get());
    } else {
      System.out.println("Project with id "  + paramsArray[0] + " not found");
    }
  }

  private void update(String params) throws ParseException {
    String[] paramsArray = params.split(" ");
    Optional<Project> optionalProject = projectDao
        .get(Long.parseLong(paramsArray[0]));
    if (optionalProject.isPresent()) {
      Project project = optionalProject.get();
      project.setName(paramsArray[1]);
      project.setCreated(new Date(format.parse(paramsArray[2]).getTime()));
      project.setCost(Double.parseDouble(paramsArray[3]));
      projectDao.update(project);
    } else {
      System.out.println("Project with id "  + paramsArray[0] + " not found");
    }
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------Projects menu---------------------");
    LOGGER.info("Projects command list:");
    LOGGER.info("create [project_name] [created(format dd-MM-yyyy)] [cost]");
    LOGGER.info("get [id]");
    LOGGER.info("getAll");
    LOGGER.info("update [project_name] [created(format dd-MM-yyyy)] [cost]");
    LOGGER.info("delete [id]");
  }
}