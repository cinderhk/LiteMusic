package com.cinderhk.litemusic.service;

import com.cinderhk.litemusic.entity.Playlistinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dxy
 * @since 2024-10-10
 */
public interface IPlaylistinfoService extends IService<Playlistinfo> {
    List<Playlistinfo> listById(Long id);
}
