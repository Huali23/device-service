package com.hc.device.entity.asset.dtos;

import com.hc.device.entity.asset.BaseDevice;
import com.hc.device.entity.asset.Device;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeviceDTO extends BaseDevice implements Serializable, Device {

    private static final long serialVersionUID = 1L;

    private Integer catalog;
    private Byte enabled;
    private Integer state;
    private Byte showInClient;

}
