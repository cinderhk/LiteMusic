package com.cinderhk.litemusic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("cos_config")
@ApiModel(value="CosConfig对象", description="")
public class CosConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "secretId", type = IdType.NONE)
    private String secretId;

    @TableField(value = "secretKey")
    private String secretKey;

    @TableField(value = "bucketName")
    private String bucketName;

    @TableField(value = "region")
    private String region;


}
