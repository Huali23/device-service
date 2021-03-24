package com.hc.device.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hc.device.entity.asset.dos.ProbeDO;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbeMapper extends BaseMapper<ProbeDO> {
}