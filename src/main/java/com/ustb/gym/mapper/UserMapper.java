package com.ustb.gym.mapper;

import com.ustb.gym.pojo.Admin;
import com.ustb.gym.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xumin
 * @Date: 2023/05/17/18:18
 * @Description:
 */
public interface UserMapper {
    //添加用户信息
    void addUser(User user);

    //查询所有用户信息
    List<User> allUser();

    //name唯一
    User getUserByName(@Param("name") String name);

    //根据name查询管理员信息
    Admin toAdmin(@Param("name") String name);

    //更改金额
    void upBal(@Param("vipBal") Integer vipBal,@Param("uid") Integer uid);

    List<User> so(@Param("key") String key);

    User userByUid(@Param("uid") Integer uid);

    void upU(User user);

    void deU(@Param("uid") Integer uid);
}
