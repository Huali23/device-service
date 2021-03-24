package com.hc.device.entity.asset.dtos;


import com.hc.device.entity.asset.BaseAsset;
import com.hc.device.entity.asset.type.ProbeType;
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
public class ProbeDTO  extends BaseAsset<ProbeType> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String timeInterval;
    private String savingInterval;
    private String transform;
    private String warnCond;
    private String memo;
    private Integer removed;

    private Integer state;


    @Builder.Default
    private int grade = 2;


    public Integer getId(){
        return this.id;
    }

    public Integer getParent() {
        return this.parent;
    }


}
