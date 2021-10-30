package com.goit.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.goit.model.Developer;

public class DeveloperDao extends AbstractDao<Developer> {

  private static final Logger LOGGER = LogManager.getLogger(DeveloperDao.class);

  @Override
  String getTableName() {
    return "developers";
  }

  @Override
  Developer mapToEntity(ResultSet rs) throws SQLException {

    Developer developer = new Developer();
    developer.setId(rs.getLong("id"));
    developer.setLastName(rs.getString("last_name"));
    developer.setFirstName(rs.getString("first_name"));
    developer.setSurname(rs.getString("surname"));
    developer.setDeveloperAge(rs.getInt("developer_age"));
    developer.setDateOfBirth(rs.getDate("date_of_birth"));
    developer.setGender(rs.getString("gender"));
    developer.setCompanyId(rs.getLong("company_id"));
    developer.setSalary(rs.getDouble("salary"));
    return developer;
  }

  @Override
  public Optional<Developer> create(Developer developer) {
    String sql = "insert into developers"
        + "(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id, salary)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, developer.getLastName());
      ps.setString(2, developer.getFirstName());
      ps.setString(3, developer.getSurname());
      ps.setInt(4, developer.getDeveloperAge());
      ps.setDate(5, (Date) developer.getDateOfBirth());
      ps.setString(6, developer.getGender());
      ps.setLong(7, developer.getCompanyId());
      ps.setDouble(8, developer.getSalary());
    });
    LOGGER.info("Record was created");
    return Optional.empty();
  }

  @Override
  public void update(Developer developer) {
    String sql = "update developers "
        + "set last_name = ?, first_name = ?, surname = ?,"
        + " developer_age = ?, date_of_birth = ?, gender = ?, company_id = ?, salary = ?"
        + " where id = ?";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, developer.getLastName());
      ps.setString(2, developer.getFirstName());
      ps.setString(3, developer.getSurname());
      ps.setInt(4, developer.getDeveloperAge());
      ps.setDate(5, (Date) developer.getDateOfBirth());
      ps.setString(6, developer.getGender());
      ps.setLong(7, developer.getCompanyId());
      ps.setDouble(8, developer.getSalary());
      ps.setLong(9, developer.getId());
    });
    LOGGER.info("Record was updated");
  }
}