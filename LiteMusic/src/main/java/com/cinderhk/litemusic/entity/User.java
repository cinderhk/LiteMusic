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
@TableName("user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户唯一ID",example = "1")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名",example = "test")
    private String username;

    @ApiModelProperty(value = "用户邮箱",example = "test@qq.com")
    private String email;

    @ApiModelProperty(value = "密码哈希值",example = "123")
    private String passwordHash;

    @ApiModelProperty(value = "用户性别",example = "male")
    private String gender;

    @ApiModelProperty(value = "用户注册日期",example = "2024-09-28 11:22:33")
    private LocalDateTime signupDate;

    @ApiModelProperty(value = "用户账户状态",example = "active")
    private String status;

    @ApiModelProperty(value = "用户类型",example = "xxx")
    private int type;

}
