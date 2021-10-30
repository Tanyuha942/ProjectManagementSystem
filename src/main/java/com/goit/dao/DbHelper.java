package com.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.goit.config.DataSourceHolder;
import java.sql.*;

public class DbHelper {

    private static final Logger LOGGER = LogManager.getLogger(DbHelper.class);

    public static int executeWithPreparedStatement(String sql, ParameterSetter psCall) {

        try (Connection connection = DataSourceHolder.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            psCall.set(ps);
            return ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception while trying do SQL request", e);
            return 0;
        }
    }

//    public static Optional<Long> executePreparedStatementAndGetId(String sql, ParameterSetter psCall) throws SqlReturnedException {
//        try (Connection connection = DataSourceHolder.getDataSource().getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql)) {
//            psCall.set(ps);
//            ps.executeUpdate();
//            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    return Optional.of(generatedKeys.getLong(1));
//                } else {
//                    throw new SqlReturnedException("Execution failed, no one entity was returned");
//                }
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Exception while trying do SQL request", e);
//        }
//        return Optional.empty();
//    }

    public static ResultSet getWithPreparedStatement(String sql, ParameterSetter psCall) throws SQLException {
        try (Connection connection = DataSourceHolder.getDataSource().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            psCall.set(ps);
            return ps.executeQuery();
        }
    }

    @FunctionalInterface
    public interface ParameterSetter {
        void set(PreparedStatement ps) throws SQLException;
    }
}