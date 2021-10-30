package com.goit.dao;

import com.goit.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerDao extends AbstractDao<Customer> {

  private static final Logger LOGGER = LogManager.getLogger(CustomerDao.class);

  @Override
  String getTableName() {
    return "customers";
  }

  @Override
  Customer mapToEntity(ResultSet rs) throws SQLException {
    Customer customer = new Customer();
    customer.setId(rs.getLong("id"));
    customer.setName(rs.getString("customer_name"));
    return customer;
  }

  @Override
  public Optional<Customer> create(Customer customer) {
    String sql = "insert into customers(customer_name) values (?)";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, customer.getName());
    });
    LOGGER.info("Record was created");
    return Optional.empty();
  }

  @Override
  public void update(Customer customer) {
    String sql = "update customers set customer_name = ? where id = ?";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, customer.getName());
      ps.setLong(2, customer.getId());
    });
    LOGGER.info("Record was updated");
  }
}