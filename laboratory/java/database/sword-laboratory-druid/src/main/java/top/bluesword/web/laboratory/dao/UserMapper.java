package top.bluesword.web.laboratory.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import top.bluesword.web.laboratory.entity.User;

import java.util.List;

/**
 * @author 李林峰
 */
public interface UserMapper extends BaseMapper<User> {
	
	@Select("SELECT * FROM `user`")
	@Results({
        @Result(id=true,property="id",column="id"),
        @Result(property="username",column="username"),
        @Result(property="roleList",column="id",javaType=List.class,
        	many=@Many(select="top.bluesword.web.laboratory.dao.RoleMapper.getRoleListByUserid"))
    })
	List<User> getUserAndRole();
}