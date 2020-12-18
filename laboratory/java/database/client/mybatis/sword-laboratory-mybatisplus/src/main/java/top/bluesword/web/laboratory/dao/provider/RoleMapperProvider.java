package top.bluesword.web.laboratory.dao.provider;

public class RoleMapperProvider{
	
	public String getRoleListByUserid(Integer userId) {
		System.out.println("SQL:getRoleListByUserid开始生成");
        return "SELECT * FROM role LEFT JOIN user_role ur ON ur.role_id = role.id WHERE ur.user_id = "+userId;
    }
}