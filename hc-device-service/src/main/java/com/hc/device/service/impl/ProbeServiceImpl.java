package com.hc.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hc.device.dao.ProbeMapper;
import com.hc.device.entity.asset.BaseAsset;
import com.hc.device.entity.asset.dos.ProbeDO;
import com.hc.device.entity.asset.dtos.ProbeDTO;
import com.hc.device.entity.asset.type.ProbeType;
import com.hc.device.service.ProbeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jnyou
 * @since 2020-12-21
 */
@Service
public class ProbeServiceImpl extends ServiceImpl<ProbeMapper, ProbeDO> implements ProbeService {

    @Override
    public BaseAsset getProbe(Integer id) {
        return this.transProbeDTO(this.getById(id));
    }

    @Override
    public List<ProbeDO> findAll() {
        PageHelper.startPage(1, 10);
        return this.list();
    }

    @Override
    public List<ProbeDTO> transProbeDTOList(List<ProbeDO> probeDOS) {
        List<ProbeDTO> probeDTOS = new ArrayList<>();
        for (ProbeDO probeDO : probeDOS) {
            probeDTOS.add(this.transProbeDTO(probeDO));
        }
        return probeDTOS;
    }

    @Override
    public List<ProbeDTO> listProbe() {
        List<ProbeDO> probeDOs = this.list();
        List<ProbeDTO> probeDTOs = new ArrayList<>();
        for (ProbeDO probeDO : probeDOs) {
            probeDTOs.add(this.transProbeDTO(probeDO));
        }
        return probeDTOs;
    }

    @Override
    public ProbeDTO transProbeDTO(ProbeDO probeDO) {
        return ProbeDTO.builder()
                .id(probeDO.getId())
                .parent(probeDO.getDeviceId())
                .type(new ProbeType(probeDO.getType()))
                .name(probeDO.getName())
                .caption(probeDO.getCaption())
                .grade(NumberConstant.Number.CONSTANT_TWO)
                .state(probeDO.getState())
                .build();
    }

}
