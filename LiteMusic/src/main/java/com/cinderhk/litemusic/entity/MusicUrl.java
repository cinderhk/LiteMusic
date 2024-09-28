package com.cinderhk.litemusic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("music_url")
@ApiModel(value="MusicUrl对象", description="")
public class MusicUrl implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "音乐ID",example = "1")
    @TableId(value = "musicrid", type = IdType.NONE)
    private Long musicrid;

    @ApiModelProperty(value = "类型，区分普通用户和vip用户，默认：0，vip：1",example = "0")
    private String type;

    @ApiModelProperty(value = "音乐url地址",example = "https://www.baidu.com")
    private String url;


}
