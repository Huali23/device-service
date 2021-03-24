package com.hc.device.entity.asset;

public interface Device extends CompoundAsset, AssetGrade{

    void addChild(Device child);
}
