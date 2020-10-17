package zuel.huziliu.dao.user;

import zuel.huziliu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
}
