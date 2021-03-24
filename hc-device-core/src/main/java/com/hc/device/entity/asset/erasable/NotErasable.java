package com.hc.device.entity.asset.erasable;

/**
 * @author liujingeng
 * @description 根据set集合表示是否删除
 * @create 2020/12/31
 */
public class NotErasable implements Erasable{

    @Override
    public boolean expression(int parentId) {
        return false;
    }
}