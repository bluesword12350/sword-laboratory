package top.bluesword.web.laboratory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.bluesword.web.laboratory.dao.UserMapper;
import top.bluesword.web.laboratory.entity.User;
import top.bluesword.web.laboratory.service.UserService;

/**
 * @author 李林峰
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}