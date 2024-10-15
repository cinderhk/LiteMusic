package com.cinderhk.litemusic.service.impl;

import com.cinderhk.litemusic.entity.Playlistinfo;
import com.cinderhk.litemusic.mapper.PlaylistinfoMapper;
import com.cinderhk.litemusic.service.IPlaylistinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dxy
 * @since 2024-10-10
 */
@Service
public class PlaylistinfoServiceImpl extends ServiceImpl<PlaylistinfoMapper, Playlistinfo> implements IPlaylistinfoService {

    @Autowired
    private PlaylistinfoMapper playlistinfoMapper;
    @Override
    public List<Playlistinfo> listById(Long id) {
        List<Playlistinfo> playlistinfo = playlistinfoMapper.listById(id);
        return playlistinfo;
//        return list;
    }
}
