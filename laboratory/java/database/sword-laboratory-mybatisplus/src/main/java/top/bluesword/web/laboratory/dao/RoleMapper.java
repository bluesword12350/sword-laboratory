package top.bluesword.web.laboratory.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.SelectProvider;

import top.bluesword.web.laboratory.dao.provider.RoleMapperProvider;
import top.bluesword.web.laboratory.entity.Role;

/**
 * @author 李林峰
 */
public interface RoleMapper extends BaseMapper<Role> {

	/**
	 * 通过用户ID查询角色列表
	 * @param userId 用户ID
	 * @return 角色列表
	 */
	@SelectProvider(type = RoleMapperProvider.class, method = "getRoleListByUserid")
	List<Role> getRoleListByUserid(Integer userId);
}