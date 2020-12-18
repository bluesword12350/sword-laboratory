package top.bluesword.web.laboratory.service;

import java.io.Serializable;
import java.util.List;



/**
 * 基础服务类
 * @author 李林峰
 */
public interface BaseService<T> {
    /**
     * 查询单个实体
     * @param entity
     * @return
     */
    public T selectOne(T entity);
    public void insert(T entity);
    public List<T> selectAll();
    public int countAll();
    public int delete(T entity);
    public int deleteByPrimaryKey(Serializable key);
	/**
	 * 根据主键修改，更新null值
	 * @param entity
	 * @return
	 */
	public int updateByPrimaryKey(T entity);
	/**
	 * 根据主键修改，不更新null值
	 * @param entity
	 * @return
	 */
	int updateByPrimaryKeySelective(T entity);
	public void deleteList(List<T> entitylist);
}
