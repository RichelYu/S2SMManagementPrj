package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Program;
import entity.User;
import org.apache.catalina.core.ApplicationContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import util.LogUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author:RichelYu
 */

@ParentPackage("test")
@Namespace("/")
@Action
public class IndexAction extends ActionSupport {
    @Autowired
    UserService userService;

    IndexAction(UserService userService) {
        this.userService = userService;
    }

    private String userId;
    private String password;
    private String userName;
    private List<User> users;
    private List<Program> programs;
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    HttpServletRequest request;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    /**
     * 主页跳转  包括权限分配看到不同界面的判断
     *
     * @return
     */
    public String indexActionRedirect() {
        ActionContext actionContext = ActionContext.getContext();

        request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        if (userService.getProjectList(user)==null || userService.getUserList(user) == null){
            return "error";
        }
        int projectNum = userService.getProjectList(user).size();
        actionContext.put("projectNum",projectNum);
        int userNum = userService.getUserList(user).size();
        actionContext.put("userNum",userNum);
        return "success";
    }

    /**
     * 登录
     *
     * @return
     */
    public String login() {
        User user1 = userService.getUser(userId);
        if (user1 != null && password.equals(user1.getPassword())) {
            LogUtil.log("登录成功");
            request = ServletActionContext.getRequest();
            request.getSession().setAttribute("user", user1);
            request.getSession().setAttribute("userId", userId);
            request.getSession().setAttribute("userName", user1.getUserName());
            return "success";
        }
        return "error";
    }

    /**
     * 注册跳转
     *
     * @return
     */
    public String registerAction() {

        return "success";
    }

    /**
     * 注册
     *
     * @return
     */
    public String register() {
        if (userService.getUser(userId) != null) {
            LogUtil.log("手机号重复");
            return "error";
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        //这里实际上是手机号
        user.setUserId(Long.parseLong(userId));

        userService.addUser(user);
        request = ServletActionContext.getRequest();
        request.getSession().setAttribute("userId", userId);
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("userName", userName);

        LogUtil.log("注册成功");
        return "success";
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    public String userListAction() {
        request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        users = userService.getUserList(user);
        if (users == null) {
            return "error";
        }
        return "success";
    }

    /**
     * 查看项目列表
     *
     * @return
     */
    public String projectListAction() {
        ActionContext actionContext = ActionContext.getContext();
        request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        List<Program> programs = userService.getProjectList(user);
        if (programs == null) {
            return "error";
        }
        actionContext.put("programs",programs);
        return "success";
    }

    public String addNewProjectRedirectAction(){
        return "success";
    }

    /**
     * 添加项目
     * @return
     */
    public String addNewProjectAction(){
        request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        Program program = new Program();
        program.setName(name);
        program.setUrl(url);
        program.setCreateTime(new Date());
        program.setUpdateTime(new Date());
        userService.publishProject(user,program);
        return "success";
    }

    /**
     * 删除项目  这里是逻辑删除
     * @return
     */
    public String deleteProjectAction(){
        request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String projectId = request.getParameter("id");
        userService.deleteProject(projectId);
        return "success";
    }



}
