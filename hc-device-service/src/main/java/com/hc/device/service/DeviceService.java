package com.hc.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.device.entity.asset.Asset;
import com.hc.device.entity.asset.dos.DeviceDO;
import com.hc.device.entity.asset.dtos.DeviceDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DeviceService extends IService<DeviceDO> {

    DeviceDO findDevice(Integer id);

    DeviceDO updateDeviceState(Integer id, Integer state);

    DeviceDTO getDevice(Integer id);

    List<DeviceDTO> listDevice();

    Map<Integer, DeviceDTO> mapDevice();

    Map<Integer, DeviceDTO> mapDevice(List<DeviceDO> deviceDOs);

    List<DeviceDTO> listChildrenTree(DeviceDTO DeviceDtO);

    List<DeviceDTO> listChildrenTree(Integer parentId);

    List<? extends Asset> listChildrenTree(Integer parentId, Map<Integer, DeviceDTO> assetMap);

    List<DeviceDTO> listChildrenTree(Set<Integer> parentId);

    List<DeviceDTO> listChildrenTree(Set<Integer> parentId, Map<Integer, DeviceDTO> assetMap);

    DeviceDTO transDeviceDTO(DeviceDO DeviceDO);

    List<DeviceDTO> transDeviceDTOList(List<DeviceDO> deviceDOs);

}
