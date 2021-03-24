package com.hc.device.entity.asset.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-hc-device-entity-TDevice")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_device")
public class DeviceDO implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    @TableField(value = "uuid")
    @ApiModelProperty(value="")
    private Integer uuid;

    @TableField(value = "parent")
    @ApiModelProperty(value="")
    private Integer parent;

    /**
     * 区分设备类型，是否需要采集等，场景是摄像头。
     */
    @TableField(value = "type")
    @ApiModelProperty(value="区分设备类型，是否需要采集等，场景是摄像头。")
    private String type;

    /**
     * 设备分类，等同标签功能
     */
    @TableField(value = "catalog")
    @ApiModelProperty(value="设备分类，等同标签功能")
    private Short catalog;

    @TableField(value = "name")
    @ApiModelProperty(value="")
    private String name;

    @TableField(value = "caption")
    @ApiModelProperty(value="")
    private String caption;

    /**
     * 是否启用
     */
    @TableField(value = "enabled")
    @ApiModelProperty(value="是否启用")
    private Byte enabled;

    /**
     * 维护在内存里
     */
    @TableField(value = "state")
    @ApiModelProperty(value="维护在内存里")
    private Integer state;

    /**
     * 逻辑删除
     */
    @TableField(value = "removed")
    @ApiModelProperty(value="逻辑删除")
    private Byte removed;

    /**
     * 是否在客户端显示
     */
    @TableField(value = "show_in_client")
    @ApiModelProperty(value="是否在客户端显示")
    private Byte showInClient;

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

    public static final String COL_UUID = "uuid";

    public static final String COL_PARENT = "parent";

    public static final String COL_TYPE = "type";

    public static final String COL_CATALOG = "catalog";

    public static final String COL_NAME = "name";

    public static final String COL_CAPTION = "caption";

    public static final String COL_ENABLED = "enabled";

    public static final String COL_STATE = "state";

    public static final String COL_REMOVED = "removed";

    public static final String COL_SHOW_IN_CLIENT = "show_in_client";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}