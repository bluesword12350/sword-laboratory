package top.bluesword.web.laboratory.entity;

import java.util.List;

import javax.persistence.*;

public class User {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * hash密码
     */
    private String password;

    /**
     * 状态 0为禁止，1为启用
     */
    private Integer state;
    
    /**
     * 角色列表
     */
    @Transient
    private List<Role> roleList;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取hash密码
     *
     * @return password - hash密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置hash密码
     *
     * @param password hash密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取状态 0为禁止，1为启用
     *
     * @return state - 状态 0为禁止，1为启用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态 0为禁止，1为启用
     *
     * @param state 状态 0为禁止，1为启用
     */
    public void setState(Integer state) {
        this.state = state;
    }

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}