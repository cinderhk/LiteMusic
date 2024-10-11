package com.cinderhk.litemusic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dxy
 * @since 2024-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("playlistcard")
@ApiModel(value="Playlistcard对象", description="")
public class Playlistcard implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.NONE)
    private Long id;

    @ApiModelProperty(value = "播放列表卡片标题")
    private String name;

    @ApiModelProperty(value = "播放列表卡片图片的URL")
    private String url;

    @ApiModelProperty(value = "播放列表卡片记录的创建时间")
    private LocalDateTime createdAt;


}
