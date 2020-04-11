package constant;

/**
 * @Author:RichelYu
 */
public enum RoleEnums {
    ADMIN(0, "管理员"),
    USER(1, "普通用户"),
    BLACK_USER(-1,"黑名单用户");
    private Integer typeCode;
    private String typeDesc;

    RoleEnums(Integer typeCode, String typeDesc) {
        this.typeCode = typeCode;
        this.typeDesc = typeDesc;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

}
