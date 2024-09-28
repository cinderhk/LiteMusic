package com.cinderhk.litemusic.controller;


import com.cinderhk.litemusic.cos.GeneratePresignedUrl;
import com.cinderhk.litemusic.entity.CosConfig;
import com.cinderhk.litemusic.entity.MusicUrl;
import com.cinderhk.litemusic.entity.Musiclist;
import com.cinderhk.litemusic.entity.User;
import com.cinderhk.litemusic.service.ICosConfigService;
import com.cinderhk.litemusic.service.IMusicUrlService;
import com.cinderhk.litemusic.service.IUserService;
import com.cinderhk.litemusic.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dxy
 * @since 2024-09-28
 */
@RestController
@RequestMapping("/music_url")
public class MusicUrlController {

    @Autowired
    private IMusicUrlService musicUrlService;
    @Autowired
    private ICosConfigService cosConfigService;
    @Autowired
    private IUserService userService;

    GeneratePresignedUrl generatePresignedUrl =new GeneratePresignedUrl();

    @PostMapping("/ById")
    @ApiOperation(value = "根据ID查询音乐url信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "musicrid",value = "音乐id",required = true ,dataType = "long")
    )
    public R ById(long musicrid, int uid){
        int type = 0;
        update_musicUrl(musicrid);
        User user =userService.getById(uid);
        if (user!=null){
             type = user.getType();
        }
        else {
            return R.error().message("该用户不存在");
        }
        MusicUrl musicUrl = musicUrlService.getById(musicrid);

        if (musicUrl != null || musicUrl.getType().equals(type)){
            //System.out.println(update_musicUrl(musicrid));
            return R.ok().data("musicURL",musicUrl);

        }
        else if (type == 0){
            return R.error().message("请开通会员畅听音乐！");
        }else {
            return R.error().message("该歌曲不存在，请听其他音乐！");
        }
    }

    public R update_musicUrl(Long musicrid){

//        默认使用第一个cos配置信息
        CosConfig cosConfig = cosConfigService.list().get(0);

        R r= generatePresignedUrl.generatePresignedDownloadUrl(cosConfig,"/music/" + musicrid + ".mp3");
        MusicUrl musicUrl = musicUrlService.getById(musicrid);
        Map<String,Object> map = r.getData();
        String url = map.get("url").toString();
        System.out.println(url);
        if ( url != null){
            musicUrl.setUrl(url);
            musicUrlService.updateById(musicUrl);
            return R.ok().data("musicUrl",musicUrl);
        }
        return R.error();

    }

    @PostMapping("/insert")
    @ApiOperation(value = "根据ID添加音乐信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "musicrid",value = "音乐id",required = true ,dataType = "long")
    )
    public R insertInfo(@RequestBody MusicUrl musicUrl){
        boolean save = musicUrlService.save(musicUrl);
        if (save){
            return R.ok().data("musicUrl", musicUrl);
        }
        return R.error();
    }



}
