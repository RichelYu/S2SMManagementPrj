package constant;
/**
 * @Author:RichelYu
 */
public enum  AuthorityEnums {
    SELECT("查询用户",5),
    SELECT_PROJECT("查询项目",4),
    EDIT_PROJECT("修改项目",3),
    DELETE_PROJECT("删除项目",2),
    ADD_PROJECT("新增项目",1)




    ;

    private String authority;
    private Integer type;

    AuthorityEnums(String authority,Integer type){
        this.authority = authority;
        this.type = type;
    }

    public String getAuthority() {
        return authority;
    }

    public Integer getType() {
        return type;
    }
}
