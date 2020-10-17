package zuel.huziliu.service.user;

import org.junit.Test;
import zuel.huziliu.dao.user.BaseDao;
import zuel.huziliu.dao.user.UserDao;
import zuel.huziliu.dao.user.UserDaoimp;
import zuel.huziliu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceimp implements userService{
    private UserDao userDao;
    private BaseDao baseDao;

    public UserServiceimp() {
        userDao=new UserDaoimp();
        baseDao=new BaseDao();
    }

    public User login(String userCode, String password) {
        User user=null;
        Connection connection=null;
        try {
           connection=baseDao.getConnection();
           user = userDao.getLoginUser(connection, userCode);
       }catch (SQLException e){
        e.printStackTrace();
       }finally {
           baseDao.close_Resource(connection,null,null);
       }
       return user;
    }

    @Test
    public void test(){
        UserServiceimp userServiceimp= new UserServiceimp();
        User admin = userServiceimp.login("admin", "123456");
        System.out.println(admin.getPhone());
    }

}
