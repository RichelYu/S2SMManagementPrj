package entity;

import java.util.Date;
/**
 * @Author:RichelYu
 */
public class Program {
    private Integer id;
    private String name;
    private String url;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }



    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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
}
