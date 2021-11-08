package com.goit.console.commands;

import com.goit.console.Command;
import com.goit.dao.CustomerDao;
import com.goit.model.Customer;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerCommand implements Command {

  private static final Logger LOGGER = LogManager.getLogger(CustomerCommand.class);
  private final CustomerDao customerDao = new CustomerDao();

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
    Customer customer = new Customer();
    customer.setName(paramsArray[0]);
    customerDao.create(customer);
  }

  private void get(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Customer> customer = customerDao
        .get(Long.parseLong(paramsArray[0]));
    if (customer.isPresent()) {
      System.out.println(customer.get());
    } else {
      System.out.println("Customer with id "  + paramsArray[0] + " not found");
    }
  }

  private void getAll() {
    List<Customer> all = customerDao.getAll();
    System.out.println("Returned "+ all.size() + " customers");
    for (Customer customer : all) {
      System.out.println(customer);
    }
  }

  private void delete(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Customer> customer = customerDao
        .get(Long.parseLong(paramsArray[0]));
    if (customer.isPresent()) {
      customerDao.delete(customer.get());
    } else {
      System.out.println("Customer with id "  + paramsArray[0] + " not found");
    }
  }

  private void update(String params) {
    String[] paramsArray = params.split(" ");
    Optional<Customer> optionalCustomer = customerDao
        .get(Long.parseLong(paramsArray[0]));
    if (optionalCustomer.isPresent()) {
      Customer customer = optionalCustomer.get();
      customer.setName(paramsArray[1]);
      customerDao.update(customer);
    } else {
      System.out.println("Customer with id "  + paramsArray[0] + " not found");
    }
  }

  @Override
  public void printActiveMenu() {
    LOGGER.info("---------------------Customer menu---------------------");
    LOGGER.info("Customers command list: ");
    LOGGER.info("create [customer_name]");
    LOGGER.info("get [id]");
    LOGGER.info("getAll");
    LOGGER.info("update [customer_name]");
    LOGGER.info("delete [id]");
  }
}