package com.guoguo.suan.likou.erfen;

/**
 * @author xiaoguo
 * @date2022/1/9 0009 22:56
 */
public class BadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start<end){
            int mid = start+((end-start)>>1);
            if(isBadVersion(mid)){
                end = mid;
            }else {
                start = start+1;
            }
        }
        return start;
    }
}
