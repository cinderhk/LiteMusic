package com.cinderhk.litemusic.controller;


import com.cinderhk.litemusic.entity.Albums;
import com.cinderhk.litemusic.service.IAlbumsService;
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
 * @since 2024-09-28
 */
@RestController
@RequestMapping("/albums")
public class AlbumsController {

    @Autowired
    private IAlbumsService albumsService;

    @PostMapping("/list")
    @ApiOperation(value = "列出所有专辑")
    public R list(){
        List<Albums> list = albumsService.list();

        return R.ok().data("albums", list);

    }

    @PostMapping("/ById")
    @ApiOperation(value = "根据ID查询专辑")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "album_id",value = "专辑唯一id",required = true ,dataType = "int")
    )
    public  R ById(Integer album_id){
        Albums albums = albumsService.getById(album_id);
        if (albums != null){
            return R.ok().data("albums", albums);
        }else {
            return R.error();
        }
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加专辑")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "albums",value = "专辑信息",required = true ,dataType = "Albums")
    )
    public R insertInfo(@RequestBody Albums albums){
        boolean save = albumsService.save(albums);
        if (save){
            return R.ok().data("albums", albums);
        }
        return R.error();
    }


    @PostMapping("/update")
    @ApiOperation(value = "根据ID修改专辑")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "albums",value = "专辑信息",required = true ,dataType = "Albums")
    )
    public R updateById(@RequestBody Albums albums){
        boolean save = albumsService.updateById(albums);
        if (save){
            return R.ok().data("albums", albums);
        }
        return R.error();
    }


    @PostMapping("/delete")
    @ApiOperation(value = "根据ID删除专辑")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "专辑id",required = true ,dataType = "int")
    )

    public R deleteById(String id){
        boolean b = albumsService.removeById(id);
        if (b){
            return R.ok();
        }
        return R.error();
    }




}
