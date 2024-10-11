package com.cinderhk.litemusic.controller;


import com.cinderhk.litemusic.entity.Albums;
import com.cinderhk.litemusic.entity.Playlistcard;
import com.cinderhk.litemusic.service.IAlbumsService;
import com.cinderhk.litemusic.service.IPlaylistcardService;
import com.cinderhk.litemusic.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dxy
 * @since 2024-10-10
 */
@RestController
@RequestMapping("/playlistcard")
public class PlaylistcardController {
    @Autowired
    private IPlaylistcardService playlistcardService;

    @PostMapping("/list")
    @ApiOperation(value = "列出所有播放列表卡片")
    public R list(){
        List<Playlistcard> list = playlistcardService.list();

        return R.ok().data("playlistcard", list);

    }

    @PostMapping("/ById")
    @ApiOperation(value = "根据ID查询播放列表卡片")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "播放列表卡片唯一ID",required = true ,dataType = "long")
    )
    public  R ById(long id){
        Playlistcard playlistcard = playlistcardService.getById(id);
        if (playlistcard != null){
            return R.ok().data("playlistcard", playlistcard);
        }else {
            return R.error();
        }
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加播放列表卡片")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "playlistcard",value = "播放列表卡片信息",required = true ,dataType = "Playlistcard")
    )
    public R insertInfo(@RequestBody Playlistcard playlistcard){
        boolean save = playlistcardService.save(playlistcard);
        if (save){
            return R.ok().data("playlistcard", playlistcard);
        }
        return R.error();
    }


    @PostMapping("/update")
    @ApiOperation(value = "根据ID修改播放列表卡片")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "playlistcard",value = "播放列表卡片信息",required = true ,dataType = "Playlistcard")
    )
    public R updateById(@RequestBody Playlistcard playlistcard){
        boolean save = playlistcardService.updateById(playlistcard);
        if (save){
            return R.ok().data("playlistcard", playlistcard);
        }
        return R.error();
    }


    @PostMapping("/delete")
    @ApiOperation(value = "根据ID删除播放列表卡片")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "播放列表卡片ID",required = true ,dataType = "long")
    )

    public R deleteById(String id){
        boolean b = playlistcardService.removeById(id);
        if (b){
            return R.ok();
        }
        return R.error();
    }



}
