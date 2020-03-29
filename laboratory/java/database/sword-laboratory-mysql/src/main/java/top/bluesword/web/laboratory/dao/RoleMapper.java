package top.bluesword.web.laboratory.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import top.bluesword.web.laboratory.dao.provider.RoleMapperProvider;
import top.bluesword.web.laboratory.entity.Role;

@Repository
public interface RoleMapper extends Mapper<Role> {
	
	@SelectProvider(type = RoleMapperProvider.class, method = "getRoleListByUserid")
	List<Role> getRoleListByUserid(Integer userId);
}