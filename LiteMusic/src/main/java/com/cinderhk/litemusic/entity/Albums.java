package com.cinderhk.litemusic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("albums")
@ApiModel(value="Albums对象", description="")
public class Albums implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "专辑唯一ID",example = "1")
    @TableId(value = "album_id", type = IdType.AUTO)
    private Integer albumId;

    @ApiModelProperty(value = "专辑标识",example = "3582427861")
    private String albumTag;

    @ApiModelProperty(value = "专辑标题",example = "哈哈哈哈")
    private String title;

    @ApiModelProperty(value = "专辑封面图片的URL",example = "https://www.baidu.com")
    private String coverImageUrl;

    @ApiModelProperty(value = "专辑记录创建时间",example = "2024-09-28 11:22:33")
    private LocalDateTime createdAt;


}
