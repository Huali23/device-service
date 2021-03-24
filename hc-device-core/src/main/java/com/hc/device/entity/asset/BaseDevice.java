package com.hc.device.entity.asset;

import com.hc.device.entity.asset.type.DeviceType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BaseDevice extends BaseCompoundAsset<DeviceType> implements Device {

    @Builder.Default
    protected int grade = 1;

    public int getGrade() {
        return grade;
    }

    @Override
    public void addChild(Device child) {
        child.setGrade(this.grade + 1);
        this.addChild((BaseCompoundAsset) child);
    }

    @Override
    public void setGrade(int grade) {
        this.grade = grade;
    }
}