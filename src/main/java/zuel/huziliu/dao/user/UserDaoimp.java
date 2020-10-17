package zuel.huziliu.dao.user;

import zuel.huziliu.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoimp implements UserDao{
    public User getLoginUser(Connection connection,String userCode) throws SQLException {
        BaseDao baseDao=new BaseDao();
        PreparedStatement preparedStatement=null;
        User user=null;
        String sql="select * from user where userCode=?";
        Object params[]={userCode};
        ResultSet resultSet = baseDao.query(connection, preparedStatement, sql, params);
       if(resultSet.next()){
           user=new User();
           user.setId(resultSet.getInt("id"));
           user.setUserCode(resultSet.getString("userCode"));
           user.setUser_Name(resultSet.getString("userName"));
           user.setUserPassword(resultSet.getString("userPassword"));
           user.setGender(resultSet.getInt("gender"));
           user.setBirthday(resultSet.getDate("birthday"));
           user.setPhone(resultSet.getString("phone"));
           user.setAddress(resultSet.getString("address"));
           user.setUserRole(resultSet.getInt("userRole"));
           user.setCreatedBy(resultSet.getInt("createdBy"));
           user.setCreationDate(resultSet.getDate("creationDate"));
           user.setModifyBy(resultSet.getInt("modifyBy"));
           user.setModifyDate(resultSet.getDate("modifyDate"));
       }
       baseDao.close_Resource(null,resultSet,preparedStatement);
       return user;
    }
}
