package entity;

import java.util.Date;
/**
 * @Author:RichelYu
 */
public class User {

    private Integer id;
    //这里改成了手机号
    private Long userId;
    private Integer role;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

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

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }
}
