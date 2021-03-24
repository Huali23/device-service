package com.hc.device.entity.asset.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="com-hc-device-entity-TProbeRule")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_probe_rule")
public class ProbeDO implements Serializable {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "device_id")
    @ApiModelProperty(value="")
    private Integer deviceId;

    @TableField(value = "type")
    @ApiModelProperty(value="")
    private String type;

    @TableField(value = "catalog")
    @ApiModelProperty(value="")
    private Short catalog;

    @TableField(value = "name")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "caption")
    @ApiModelProperty(value="")
    private String caption;

    /**
     * 维护在内存里
     */
    @TableField(value = "state")
    @ApiModelProperty(value="维护在内存里")
    private Integer state;

    @TableField(value = "removed")
    @ApiModelProperty(value="")
    private Byte removed;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_DEVICE_ID = "device_id";

    public static final String COL_TYPE = "type";

    public static final String COL_CATALOG = "catalog";

    public static final String COL_NAME = "name";

    public static final String COL_CAPTION = "caption";

    public static final String COL_STATE = "state";

    public static final String COL_REMOVED = "removed";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}