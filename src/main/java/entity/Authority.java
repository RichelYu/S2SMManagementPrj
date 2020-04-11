package entity;

import lombok.Data;

/**
 * @Author:RichelYu
 */
public class Authority {
    public Integer id;
    public Integer role;
    public Integer operate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public Integer getOperate() {
        return operate;
    }
}
