package zuel.huziliu.service.user;

import zuel.huziliu.pojo.User;

import java.sql.SQLException;

public interface userService {
    public User login(String userCode,String password) ;
}
