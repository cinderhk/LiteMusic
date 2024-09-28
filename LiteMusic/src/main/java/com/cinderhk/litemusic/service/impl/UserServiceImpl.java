package com.cinderhk.litemusic.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cinderhk.litemusic.entity.CustomUserDetails;
import com.cinderhk.litemusic.entity.User;
import com.cinderhk.litemusic.mapper.UserMapper;
import com.cinderhk.litemusic.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dxy
 * @since 2024-09-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    private  UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        // 使用QueryWrapper进行查询，并返回Optional封装的结果
        if (userMapper.findByUsername(username) != null) {
            return userMapper.findByUsername(username);
        }
        return null;
    }

    @Override
    public User getById(int uid) {
        User user =userMapper.selectById(uid);
        if (user != null) {
            return user;
        }
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user != null){
            UserDetails userDetails = new CustomUserDetails(user);
            return userDetails;
        }
        return null;
    }

    public boolean checkPassword(String password,User user) {
//        System.out.println(rawPasswordHash);
//        System.out.println("-----------");
//        System.out.println(user.getPasswordHash());

        if (BCrypt.checkpw(password, user.getPasswordHash())) {
            return true;
        }
        return false;
    }


    @Override
    public boolean save(User user) {
        try {
            userMapper.insert(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateById(User user) {
        try {
            userMapper.updateById(user);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean removeById(int uid) {
        try {
            userMapper.deleteById(uid);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<User> list() {
        return userMapper.selectList(null);
    }
}
