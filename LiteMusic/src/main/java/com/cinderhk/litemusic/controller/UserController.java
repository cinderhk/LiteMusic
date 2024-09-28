package com.cinderhk.litemusic.controller;


import cn.hutool.crypto.digest.BCrypt;
import com.cinderhk.litemusic.entity.User;
import com.cinderhk.litemusic.service.IUserService;
import com.cinderhk.litemusic.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dxy
 * @since 2024-09-28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/list")
    @ApiOperation(value = "查询所有用户") // 接口方法的说明
    public R list(){
        List<User> list = userService.list();
        return R.ok().data("users", list);
    }

    @PostMapping("/ById")
    @ApiOperation(value = "根据ID查询用户")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "user_id",value = "用户id",required = true ,dataType = "int")
    )
    public  R ById(Integer user_id){
        User user = userService.getById(user_id);
        if (user != null){
            return R.ok().data("user", user);
        }else {
            return R.error();
        }
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加用户")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "user",value = "用户信息",required = true ,dataType = "User")
    )
    public R insertInfo(@RequestBody User user){
        User newUser = new User();
        String pwd = BCrypt.hashpw(user.getPasswordHash(), BCrypt.gensalt());
        newUser.setPasswordHash(pwd);
        boolean save = userService.save(user);
        if (save){
            return R.ok().data("user", user);
        }
        return R.error();
    }


    @PostMapping("/update")
    @ApiOperation(value = "根据ID修改用户")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "user",value = "用户信息",required = true ,dataType = "User")
    )
    public R updateById(@RequestBody User user){
        boolean save = userService.updateById(user);
        if (save){
            return R.ok().data("user", user);
        }
        return R.error();
    }


    @PostMapping("/delete")
    @ApiOperation(value = "根据ID删除用户")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "用户id",required = true ,dataType = "int")
    )

    public R deleteById(int id){
        boolean b = userService.removeById(id);
        if (b){
            return R.ok();
        }
        return R.error();
    }


}
