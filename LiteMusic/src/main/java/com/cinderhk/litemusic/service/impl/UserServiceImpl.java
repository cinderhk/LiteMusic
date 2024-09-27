package com.cinderhk.litemusic.service.impl;

import com.cinderhk.litemusic.entity.User;
import com.cinderhk.litemusic.mapper.UserMapper;
import com.cinderhk.litemusic.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dxy
 * @since 2024-09-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
