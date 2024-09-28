package com.cinderhk.litemusic.service;

import com.cinderhk.litemusic.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dxy
 * @since 2024-09-28
 */
public interface IUserService extends UserDetailsService {


    boolean checkPassword(String password,User dbUser);

    User findByUsername(String username);


    User getById(int uid);

    List<User> list();

    boolean save(User user);

    boolean updateById(User user);

    boolean removeById(int uid);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
