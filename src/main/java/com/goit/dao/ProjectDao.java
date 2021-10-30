package com.goit.dao;

import com.goit.model.Project;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectDao extends AbstractDao<Project> {

  private static final Logger LOGGER = LogManager.getLogger(ProjectDao.class);

  @Override
  String getTableName() {
    return "projects";
  }

  @Override
  Project mapToEntity(ResultSet rs) throws SQLException {
    Project project = new Project();
    project.setId(rs.getLong("id"));
    project.setName(rs.getString("project_name"));
    project.setCreated(rs.getDate("created"));
    project.setCost(rs.getDouble("cost"));
    return project;
  }

  @Override
  public Optional<Project> create(Project project) {
    String sql = "insert into projects(project_name, created, cost) values (?, ?, ?)";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, project.getName());
      ps.setDate(2, (Date) project.getCreated());
      ps.setDouble(3, project.getCost());
    });
    LOGGER.info("Record was created");
    return Optional.empty();
  }

  @Override
  public void update(Project project) {
    String sql = "update projects set project_name = ?, created = ?, cost = ?"
        + " where id = ?";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, project.getName());
      ps.setDate(2, (Date) project.getCreated());
      ps.setDouble(3, project.getCost());
      ps.setLong(4, project.getId());
    });
    LOGGER.info("Record was updated");
  }
}