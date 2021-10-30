package com.goit.dao;

import com.goit.model.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompanyDao extends AbstractDao<Company> {

  private static final Logger LOGGER = LogManager.getLogger(CompanyDao.class);

  @Override
  String getTableName() {
    return "companies";
  }

  @Override
  Company mapToEntity(ResultSet rs) throws SQLException {
    Company company = new Company();
    company.setId(rs.getLong("id"));
    company.setName(rs.getString("company_name"));
    return company;
  }

  @Override
  public Optional create(Company company) {
    String sql = "insert into companies(company_name) values (?)";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, company.getName());
    });
    LOGGER.info("Record was created");
    return Optional.empty();
  }

  @Override
  public void update(Company company) {
    String sql = "update companies set company_name = ? where id = ?";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, company.getName());
      ps.setLong(2, company.getId());
    });
    LOGGER.info("Record was updated");
  }
}