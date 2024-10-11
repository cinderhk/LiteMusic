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
 * @since 2024-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("playlistinfo")
@ApiModel(value="Playlistinfo对象", description="")
public class Playlistinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long musicrid;


}
