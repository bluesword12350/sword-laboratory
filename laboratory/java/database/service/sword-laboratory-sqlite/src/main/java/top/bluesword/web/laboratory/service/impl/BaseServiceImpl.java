package top.bluesword.web.laboratory.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;
import top.bluesword.web.laboratory.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
    Mapper<T> baseDao;
	@Override
    public T selectOne(T entity) {
        return baseDao.selectOne(entity);
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
}