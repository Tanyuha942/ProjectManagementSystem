package com.goit.console.commands;

import java.util.*;
import java.util.function.Consumer;
import org.apache.logging.log4j.*;
import com.goit.console.Command;
import com.goit.dao.CompanyDao;
import com.goit.model.Company;

public class CompaniesCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(CompaniesCommand.class);
  private final CompanyDao companyDao = new CompanyDao();

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

  private void update(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Company> optionalCompany = companyDao
        .get(Long.parseLong(paramsArray[0]));
    if (optionalCompany.isPresent()) {
      Company company = optionalCompany.get();
      company.setName(paramsArray[1]);
      companyDao.update(company);
    } else {
      System.out.println("Company with id "  + paramsArray[0] + " not found");
    }
  }

  private void delete(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Company> company = companyDao
        .get(Long.parseLong(paramsArray[0]));
    if (company.isPresent()) {
      companyDao.delete(company.get());
    } else {
      System.out.println("Company with id "  + paramsArray[0] + " not found");
    }
  }

  private void getAll() {
    List<Company> all = companyDao.getAll();
    System.out.println("Returned "+ all.size() + " companies");
    for (Company company : all) {
      System.out.println(company);
    }
  }

  private void get(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Company> company = companyDao
        .get(Long.parseLong(paramsArray[0]));
    if (company.isPresent()) {
      System.out.println(company.get());
    } else {
      System.out.println("Company with id "  + paramsArray[0] + " not found");
    }
  }

  private void create(String params) {
    String[] paramsArray = params.split(" ");
    Company company = new Company();
    company.setName(paramsArray[0]);
    companyDao.create(company);
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------Companies menu---------------------");
    LOGGER.info("Companies command list: ");
    LOGGER.info("create [company_name]");
    LOGGER.info("get [id]");
    LOGGER.info("getAll");
    LOGGER.info(" update [company_name]");
    LOGGER.info("delete [id]");
  }
}