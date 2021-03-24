package com.hc.device.backend.controller;

import com.hc.device.entity.asset.BaseAsset;
import com.hc.device.response.Result;
import com.hc.device.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *
 * @className AssetController
 * @author: JnYou xiaojian19970910@gmail.com
 **/
@RestController
public class AssetController {

    @Autowired
    AssetService assetService;

    @GetMapping("/assets")
    Result<List<BaseAsset>> listAssets(){
        return Result.success(assetService.listAssets());
    }

    @GetMapping("/asset/{id}")
    Result<BaseAsset> getAssetById(@PathVariable("id") Integer id) {
        return Result.success(assetService.findAsset(id));
    }

}