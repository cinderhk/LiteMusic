package com.cinderhk.litemusic.controller;


import com.cinderhk.litemusic.entity.User;
import com.cinderhk.litemusic.service.IUserService;
import com.cinderhk.litemusic.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dxy
 * @since 2024-09-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "查询所有用户") // 接口方法的说明
    public R list(){
        List<User> list = userService.list();
        return R.ok().data("list", list);
    }

}
