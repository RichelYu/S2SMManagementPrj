package dao;

import entity.Program;
import entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author:RichelYu
 */
@Mapper
public interface UserMapper {

    User getUser(@Param("userId") String userId);

    void insertUser(@Param("newUser") User user);


    int getAuthorityType(@Param("role") Integer role, @Param("operate") Integer type);

    List<User> getAllUser();

    List<Program> selectAllPrograms();

    void insertProgram(@Param("program") Program program);

    void updateProjectStatus(@Param("projectId") String projectId);
}
