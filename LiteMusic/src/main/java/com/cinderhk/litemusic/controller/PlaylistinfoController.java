package com.cinderhk.litemusic.controller;


import com.cinderhk.litemusic.entity.Playlistcard;
import com.cinderhk.litemusic.entity.Playlistinfo;
import com.cinderhk.litemusic.service.IPlaylistcardService;
import com.cinderhk.litemusic.service.IPlaylistinfoService;
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
 * @since 2024-10-10
 */
@RestController
@RequestMapping("/playlistinfo")
public class PlaylistinfoController {
    @Autowired
    private IPlaylistinfoService playlistinfoService;

    @PostMapping("/listById")
    @ApiOperation(value = "根据ID查询musicrid")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "播放列表卡片唯一ID",required = true ,dataType = "long")
    )
    public R ById(long id){
        List<Playlistinfo> playlistinfo = playlistinfoService.listById(id);
        if (playlistinfo != null){
            return R.ok().data("playlistinfo", playlistinfo);
        }else {
            return R.error();
        }
    }

}
