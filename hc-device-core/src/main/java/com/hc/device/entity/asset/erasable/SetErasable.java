package com.hc.device.entity.asset.erasable;

import java.util.Set;

/**
 * @author liujingeng
 * @description 根据set集合表示是否删除
 * @create 2020/12/31
 */
public class SetErasable implements Erasable{

    private final Set<Integer> standard;

    public SetErasable(Set<Integer> standard) {
        this.standard = standard;
    }

    @Override
    public boolean expression(int parentId) {
        return !standard.contains(parentId);
    }
}