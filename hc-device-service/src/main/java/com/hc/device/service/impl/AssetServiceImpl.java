package com.hc.device.service.impl;

import com.hc.device.entity.asset.BaseAsset;
import com.hc.device.service.AssetService;
import com.hc.device.service.CompoundAssetService;
import com.hc.device.service.DeviceService;
import com.hc.device.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    DeviceService deviceService;
    @Autowired
    CompoundAssetService<BaseAsset> compoundAssetService;
    @Autowired
    ProbeService probeService;

    @Override
    public BaseAsset findAsset(Integer id) {
        BaseAsset asset = deviceService.getDevice(id);
        if (asset == null) {
            asset = probeService.getProbe(id);
        }
        return asset;
    }

    @Override
    public List<BaseAsset> listAssets() {
        List<? extends BaseAsset> devices = deviceService.listDevice();
        List<BaseAsset> assets = new ArrayList<>();
        assets.addAll(devices);
        return assets;
    }

    @Override
    public Map<Integer, BaseAsset> mapAssets() {
        Map<Integer, BaseAsset> assetMap = new HashMap<>();
        for (BaseAsset asset : this.listAssets()) {
            assetMap.put(asset.getId(), asset);
        }
        return assetMap;
    }

    @Override
    public List<BaseAsset> listChildrenTree(Integer parentId) {
        return compoundAssetService.listChildrenTree(parentId, this.mapAssets());
    }

    @Override
    public List<BaseAsset> listChildrenTree(Set<Integer> parentIds) {
        return compoundAssetService.listChildrenTree(parentIds, this.mapAssets());
    }

    @Override
    public List<BaseAsset> listChildrenTree() {
        return compoundAssetService.listChildrenTree(this.mapAssets());
    }

}