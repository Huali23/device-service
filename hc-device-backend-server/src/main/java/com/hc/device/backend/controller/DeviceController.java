package com.hc.device.backend.controller;



import com.hc.device.entity.asset.dtos.DeviceDTO;
import com.hc.device.response.Result;
import com.hc.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jnyou
 * @since 2020-12-21
 */
@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices/tree/{parentIds}")
    public Result<List<DeviceDTO>> listDevicesAndChildren(@PathVariable("parentIds") Set<Integer> parentIds) {
        List<DeviceDTO> deviceDTOS = deviceService.listChildrenTree(parentIds);
        return Result.success(deviceDTOS);
    }

}

