package com.hc.device.entity.asset.erasable;

/**
 * @author liujingeng
 * @description 根据set集合表示是否删除
 * @create 2020/12/31
 */
public class IntegerErasable implements Erasable{

    private final Integer standard;

    public IntegerErasable(Integer standard) {
        this.standard = standard;
    }


    @Override
    public boolean expression(int parentId) {
        return !this.standard.equals(parentId);
    }
}