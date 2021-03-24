package com.hc.device.service;



import com.hc.device.entity.asset.BaseAsset;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MonitorService {

    BaseAsset getMonitor(Integer id);

    List<BaseAsset> listMonitors();

    Map<Integer, BaseAsset> mapMonitors();

    List<BaseAsset> listChildrenTree();

    List<BaseAsset> listChildrenTree(Integer parentId);

    List<BaseAsset> listChildrenTree(Set<Integer> parentId);

}