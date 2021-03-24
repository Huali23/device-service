package com.hc.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hc.device.entity.asset.BaseAsset;
import com.hc.device.entity.asset.dos.ProbeDO;
import com.hc.device.entity.asset.dtos.ProbeDTO;

import java.util.List;

public interface ProbeService extends IService<ProbeDO> {

    BaseAsset getProbe(Integer id);

    List<ProbeDTO> listProbe();

    ProbeDTO transProbeDTO(ProbeDO probeDO);

    List<ProbeDO> findAll();

    List<ProbeDTO> transProbeDTOList(List<ProbeDO> probeDOS);

}
