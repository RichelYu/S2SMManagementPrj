package service;

import entity.Program;
import entity.User;

import java.util.List;
/**
 * @Author:RichelYu
 */
public interface UserService {
    User getUser(String userId);

    void addUser(User user);

    List<User> getUserList(User user);

    List<Program> getProjectList(User user);

    void publishProject(User user,Program program);

    void deleteProject(String projectId);
}
