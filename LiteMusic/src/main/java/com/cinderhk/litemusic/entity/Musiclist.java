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
 * @since 2024-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("musiclist")
@ApiModel(value="Musiclist对象", description="")
public class Musiclist implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "音乐id ",example = "1")
    @TableId(value = "musicrid", type = IdType.NONE)
    private Long musicrid;

    @ApiModelProperty(value = "音乐家",example = "周杰伦")
    private String artist;

    @ApiModelProperty(value = "音乐家图片信息",example = "https://www.baidu.com")
    private String albumpic;

    @ApiModelProperty(value = "专辑",example = "秋风吹起")
    private String album;

    @ApiModelProperty(value = "播放时长",example = "03:30")
    private String  songTimeMinutes;


}
