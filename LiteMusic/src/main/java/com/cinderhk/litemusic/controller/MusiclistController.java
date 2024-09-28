package com.cinderhk.litemusic.controller;



import com.cinderhk.litemusic.entity.Albums;
import com.cinderhk.litemusic.entity.Musiclist;
import com.cinderhk.litemusic.service.IMusiclistService;
import com.cinderhk.litemusic.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @since 2024-09-28
 */
@RestController
@RequestMapping("/musiclist")
public class MusiclistController {

    @Autowired
    private IMusiclistService musiclistService;

    @PostMapping("/list")
    @ApiOperation(value = "列出所有专辑")
    public R list(){
        List<Musiclist> list = musiclistService.list();

        return R.ok().data("Musiclist", list);

    }

    @PostMapping("/ById")
    @ApiOperation(value = "根据ID查询音乐列表信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "musicrid",value = "专辑音乐id",required = true ,dataType = "long")
    )
    public  R ById(long musicrid){
        Musiclist musiclist = musiclistService.getById(musicrid);
        if (musiclist != null){
            return R.ok().data("musiclist", musiclist);
        }else {
            return R.error();
        }
    }


}
