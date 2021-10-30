package com.goit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.goit.model.Skill;

public class SkillDao extends AbstractDao<Skill> {

  private static final Logger LOGGER = LogManager.getLogger(SkillDao.class);

  @Override
  String getTableName() {
    return "skills";
  }

  @Override
  Skill mapToEntity(ResultSet rs) throws SQLException {
    Skill skill = new Skill();
    skill.setId(rs.getLong("id"));
    skill.setIndustry(rs.getString("industry"));
    skill.setLevel(rs.getString("level_skills"));
    return skill;
  }

  @Override
  public Optional<Skill> create(Skill skill) {
    String sql = "insert into skills(industry, level_skills) values (?, ?)";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, skill.getIndustry());
      ps.setString(2, skill.getLevel());
    });
    LOGGER.info("Record was created");
    return Optional.empty();
  }

  @Override
  public void update(Skill skill) {
    String sql = "update skills set industry = ?, level_skills = ?"
        + " where id = ?";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, skill.getIndustry());
      ps.setString(2, skill.getLevel());
      ps.setLong(3, skill.getId());
    });
    LOGGER.info("Record was updated");
  }
}