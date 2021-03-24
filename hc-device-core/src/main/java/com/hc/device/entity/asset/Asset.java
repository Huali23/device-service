package com.hc.device.entity.asset;


import com.hc.device.entity.asset.type.AssetKind;
import com.hc.device.entity.asset.type.AssetType;

public interface Asset<T extends AssetType> {

    Integer getId();

    Integer getParent();

    String getName();

    String getCaption();

    T getType();

    AssetKind getKind();

}
