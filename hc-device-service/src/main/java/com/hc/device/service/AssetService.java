package com.hc.device.service;



import com.hc.device.entity.asset.BaseAsset;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AssetService {

    BaseAsset findAsset(Integer id);

    List<BaseAsset> listAssets();

    Map<Integer, BaseAsset> mapAssets();

    List<BaseAsset> listChildrenTree();

    List<BaseAsset> listChildrenTree(Integer parentId);

    List<BaseAsset> listChildrenTree(Set<Integer> parentId);

}