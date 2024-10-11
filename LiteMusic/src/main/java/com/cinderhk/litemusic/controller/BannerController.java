package com.cinderhk.litemusic.controller;


import com.cinderhk.litemusic.entity.Banner;
import com.cinderhk.litemusic.service.IBannerService;
import com.cinderhk.litemusic.utils.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dxy
 * @since 2024-10-01
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private IBannerService bannerService;

    @PostMapping("/list")
    @ApiOperation(value = "列出所有轮播图")
    public R list(){
        List<Banner> list = bannerService.list();

        return R.ok().data("Banner", list);

    }

}


