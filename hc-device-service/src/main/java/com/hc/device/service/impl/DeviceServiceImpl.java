package com.hc.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hc.device.dao.DeviceMapper;
import com.hc.device.entity.asset.dos.DeviceDO;
import com.hc.device.entity.asset.dtos.DeviceDTO;
import com.hc.device.entity.asset.type.DeviceType;
import com.hc.device.service.CompoundAssetService;
import com.hc.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceDO> implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    @Cacheable(value = {"devices"},key = "#id",sync = true)
    public DeviceDO findDevice(Integer id) {
        DeviceDO device = deviceMapper.selectById(id);
        return device;
    }

    @Override
    @CachePut(value = {"devices"},key = "#id")
    public DeviceDO updateDeviceState(Integer id,Integer state) {
        DeviceDO device = findDevice(id);
        device.setState(state);
        return device;
    }

    @Autowired
    private CompoundAssetService<DeviceDTO> compoundAssetService;

    @Override
    public DeviceDTO getDevice(Integer id) {
        return this.transDeviceDTO(this.getById(id));
    }

    @Override
    public List<DeviceDTO> listDevice(){
        return this.transDeviceDTOList(this.list());
    }

    @Override
    public Map<Integer, DeviceDTO> mapDevice() {
        return this.mapDevice(this.list());
    }

    @Override
    public Map<Integer, DeviceDTO> mapDevice(List<DeviceDO> deviceDOs) {
        Map<Integer, DeviceDTO> deviceDTOMap = new HashMap<>();
        for (DeviceDO deviceDO : deviceDOs) {
            deviceDTOMap.put(deviceDO.getId(), this.transDeviceDTO(deviceDO));
        }
        return deviceDTOMap;
    }

    @Override
    public List<DeviceDTO> listChildrenTree(DeviceDTO DeviceDtO) {
        return this.listChildrenTree(DeviceDtO.getId());
    }

    @Override
    public List<DeviceDTO> listChildrenTree(Integer parentId) {
        return this.listChildrenTree(parentId, this.mapDevice());
    }

    @Override
    public List<DeviceDTO> listChildrenTree(Integer parentId, Map<Integer, DeviceDTO> assetMap) {
        return compoundAssetService.listChildrenTree(parentId, assetMap);
    }

    @Override
    public List<DeviceDTO> listChildrenTree(Set<Integer> parentIds) {
        return this.listChildrenTree(parentIds, this.mapDevice());
    }

    @Override
    public List<DeviceDTO> listChildrenTree(Set<Integer> parentIds, Map<Integer, DeviceDTO> assetMap) {
        return compoundAssetService.listChildrenTree(parentIds, assetMap);
    }

    @Override
    public DeviceDTO transDeviceDTO(DeviceDO deviceDO) {
        return DeviceDTO.builder()
                .id(deviceDO.getId())
                .parent(deviceDO.getParent())
                .type(new DeviceType(deviceDO.getType()))
                .name(deviceDO.getName())
                .caption(deviceDO.getCaption())
                .enabled(deviceDO.getEnabled())
                .showInClient(deviceDO.getShowInClient())
                .children(new ArrayList<>())
                .build();
    }

    @Override
    public List<DeviceDTO> transDeviceDTOList(List<DeviceDO> deviceDOs) {
        List<DeviceDTO> deviceDTOs = new ArrayList<>();
        for (DeviceDO deviceDO : deviceDOs) {
            deviceDTOs.add(this.transDeviceDTO(deviceDO));
        }
        return deviceDTOs;
    }



}
