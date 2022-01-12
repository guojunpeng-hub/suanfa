package com.guoguo.suan.likou.erfen;

/**
 * @author xiaoguo
 * @date2022/1/9 0009 22:58
 */
public class VersionControl {
    public static int bad = 4;

    public boolean isBadVersion(int version) {
        return version >= bad;
    }
}
