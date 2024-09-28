package com.cinderhk.litemusic.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.cinderhk.litemusic.entity.User;
import com.cinderhk.litemusic.service.IUserService;
import com.cinderhk.litemusic.utils.JwtTokenUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    @ApiOperation(value = "登录认证")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String")
    })

    public ResponseEntity<String> login(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response) {
        // 查找用户
        User dbUser = userService.findByUsername(username);

        System.out.println(dbUser);
        if (dbUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户不存在！");
        }


        // 验证密码

        if (userService.checkPassword(password,dbUser)) {
            UserDetails userDetails = userService.loadUserByUsername(dbUser.getUsername());
            if (userDetails != null) {
                String token = jwtTokenUtil.generateToken(userDetails);
                response.setHeader("Authorization", "Bearer " + token);

                // 登录成功处理
                return ResponseEntity.ok("Login successful!");
            }else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("登录失败！");
            }

        } else {
            // 登录失败处理
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("登录失败！");
        }
    }
}