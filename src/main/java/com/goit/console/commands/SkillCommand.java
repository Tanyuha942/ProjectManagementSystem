package com.goit.console.commands;

import java.util.*;
import java.util.function.Consumer;
import org.apache.logging.log4j.*;
import com.goit.console.Command;
import com.goit.dao.SkillDao;
import com.goit.model.Skill;

public class SkillCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(SkillCommand.class);
  private final SkillDao skillDao = new SkillDao();

  @Override
  public void handle(String params, Consumer<Command> setActive) {
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

  private void create(String params) {

    String[] paramsArray = params.split(" ");
    Skill skill = new Skill();
    skill.setIndustry(paramsArray[0]);
    skill.setLevel(paramsArray[1]);
    skillDao.create(skill);
  }

  private void get(String params) {

    String[] paramsArray = params.split(" ");
    Optional<Skill> skill = skillDao
        .get(Long.parseLong(paramsArray[0]));
    if (skill.isPresent()) {
      System.out.println(skill.get());
    } else {
      System.out.println("Skill with id "  + paramsArray[0] + " not found");
    }
  }

  private void getAll() {
    List<Skill> all = skillDao.getAll();
    System.out.println("Returned "+ all.size() + " skills");
    for (Skill skill : all) {
      System.out.println(skill);
    }
  }

  private void delete(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Skill> skill = skillDao
        .get(Long.parseLong(paramsArray[0]));
    if (skill.isPresent()) {
      skillDao.delete(skill.get());
    } else {
      System.out.println("Skill with id "  + paramsArray[0] + " not found");
    }
  }

  private void update(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Skill> optionalSkill = skillDao
        .get(Long.parseLong(paramsArray[0]));
    if (optionalSkill.isPresent()) {
      Skill skill = optionalSkill.get();
      skill.setIndustry(paramsArray[1]);
      skill.setLevel(paramsArray[2]);
      skillDao.update(skill);
    } else {
      System.out.println("Skill with id "  + paramsArray[0] + " not found");
    }
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------Skills menu---------------------");
    LOGGER.info("Skills command list: create, get, getAll, update, delete");
  }
}