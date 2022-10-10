package top.bluesword.laboratory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;
import top.bluesword.laboratory.entity.User;

public interface UserMapper extends Mapper<User> {
	
	@Select("SELECT * FROM `user`")
	@Results({
        @Result(id=true,property="id",column="id"),
        @Result(property="username",column="username"),
        @Result(property="roleList",column="id",javaType=List.class,
        	many=@Many(select="top.bluesword.web.laboratory.dao.RoleMapper.getRoleListByUserid"))
    })
	List<User> getUserAndRole();
}