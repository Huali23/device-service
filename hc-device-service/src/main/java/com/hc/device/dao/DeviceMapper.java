package com.hc.device.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hc.device.entity.asset.dos.DeviceDO;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMapper extends BaseMapper<DeviceDO> {
}