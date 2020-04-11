package service.serviceImpl;

import constant.AuthorityEnums;
import constant.RoleEnums;
import dao.ProgramMapper;
import dao.UserMapper;
import entity.Program;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
import util.LogUtil;

import java.util.List;

/**
 * @Author:RichelYu
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public User getUser(String userId) {
        if (userId == null) {
            return null;
        }
        User user = userMapper.getUser(userId);
        return user;

    }

    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    public List<User> getUserList(User user) {
        //需要进行权限认证(简洁版)
        //TODO : 权限认证切面
        if (user.getRole().equals(RoleEnums.BLACK_USER.getTypeCode())) {
            LogUtil.log("黑名单用户");
            return null;
        }
        int count = userMapper.getAuthorityType(user.getRole(), AuthorityEnums.SELECT.getType());
        if (count == 0) {
            LogUtil.log("用户权限不足");
            return null;
        }
        List<User> userList = userMapper.getAllUser();
        return userList;
    }

    public List<Program> getProjectList(User user) {
        //TODO : 权限认证切面
        if (user.getRole().equals(RoleEnums.BLACK_USER.getTypeCode())) {
            return null;
        }
        //权限认证
        int count = userMapper.getAuthorityType(user.getRole(), AuthorityEnums.SELECT_PROJECT.getType());
        if (count == 0) {
            LogUtil.log("用户权限不足");
            return null;
        }
        List<Program> programs = userMapper.selectAllPrograms();
        return programs;
    }

    public void publishProject(User user,Program program) {
        //TODO : 权限认证切面
        if (user.getRole().equals(RoleEnums.BLACK_USER.getTypeCode())) {
            return;
        }
        userMapper.insertProgram(program);
    }

    public void deleteProject(String projectId) {
        userMapper.updateProjectStatus(projectId);
    }


}
