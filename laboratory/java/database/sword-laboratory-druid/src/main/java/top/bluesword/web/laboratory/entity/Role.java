package top.bluesword.web.laboratory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Role {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String rolename;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return rolename 角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * @param rolename 角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}