package top.bluesword.web.laboratory.service.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.MapperException;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import top.bluesword.web.laboratory.model.PageResult;
import top.bluesword.web.laboratory.service.BaseService;

/**
 * @author 李林峰
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
    Mapper<T> baseDao;

	@Override
    public T selectOne(T entity) {
        return baseDao.selectOne(entity);
    }
	@Override
    public T selectByPrimaryKey(Serializable id) {
        return baseDao.selectByPrimaryKey(id);
    }
    @Override
    public void insert(T entity) {
    	baseDao.insert(entity);
    }
	@Override
	public List<T> selectAll() {
		return baseDao.selectAll();
	}

	@Override
	public int countAll() {
		return baseDao.selectCount(null);
	}
	@Override
	public int delete(T entity) {
		return baseDao.delete(entity);
	}
	@Override
	public int deleteByPrimaryKey(Serializable key) {
		return baseDao.deleteByPrimaryKey(key);
	}
	@Override
	public int updateByPrimaryKey(T entity) {
		return baseDao.updateByPrimaryKey(entity);
	}
	@Override
	public int updateByPrimaryKeySelective(T entity) {
		return baseDao.updateByPrimaryKeySelective(entity);
	}
	@Override
	public void deleteList(List<T> entitylist) {
		for (T t : entitylist) {
			baseDao.delete(t);
		}
	}
	@Override
	public PageResult<T> selectToPage(Integer pageNumber, Integer pageSize, T entity) {
		PageHelper.startPage(pageNumber, pageSize);
		PageInfo<T> pageinfo = new PageInfo<>(baseDao.select(entity));
		return new PageResult<>(pageinfo);
	}
	
	@Override
	public int save(T entity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Set<EntityColumn> pkColumns = EntityHelper.getPKColumns(entity.getClass());
		if (pkColumns.size() == 1) {
			Object property = BeanUtils.getProperty(entity, pkColumns.iterator().next().getColumn());
			if (property==null || StringUtils.isBlank(property.toString())) {
				return baseDao.insert(entity);
			}else {
				return baseDao.updateByPrimaryKeySelective(entity);
			}
        } else {
            throw new MapperException("实体类[" + entity.getClass().getCanonicalName() + "]中必须只有一个带有 @Id 注解的字段");
        }
	}
}