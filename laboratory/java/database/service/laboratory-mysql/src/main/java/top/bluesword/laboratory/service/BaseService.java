package top.bluesword.laboratory.service;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import top.bluesword.laboratory.model.PageResult;


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
	/**
	 * 精确查询分页
	 * @param pageNumber
	 * @param pageSize
	 * @param entity
	 * @return
	 */
	public PageResult<T> selectToPage(Integer pageNumber, Integer pageSize, T entity);
	T selectByPrimaryKey(Serializable id);
	/**
     * 保存单个实体，包含主键时根据主键修改数据，不包含主键时插入新的一条数据
     * @param entity
     * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
     */
    public int save(T entity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
