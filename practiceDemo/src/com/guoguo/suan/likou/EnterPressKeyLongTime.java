package com.guoguo.suan.likou;

import java.util.HashMap;

/**
 * @author xiaoguo
 * @date2022/1/9 0009 10:04
 */
public class EnterPressKeyLongTime {

    public static void main(String[] args) {
        String keysPressed = "cbcd";
        int[] releaseTimes = new int[]{9,29,49,50};
        System.out.println(slowestKey(releaseTimes,keysPressed));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] chars = keysPressed.toCharArray();
        char tmpChar = chars[0];
        int tmpTime = releaseTimes[0];
        for (int i = 1; i < chars.length; i++) {
            char aChar = chars[i];
            int aCharTime = releaseTimes[i] - releaseTimes[i - 1];
            if(tmpChar=='1'){
                tmpChar = aChar;
                tmpTime = aCharTime;
            }else {
                if(tmpTime == aCharTime){
                    tmpChar = tmpChar-aChar>=0?tmpChar:aChar;
                }else if(aCharTime>tmpTime) {
                    tmpChar = aChar;
                    tmpTime = aCharTime;
                }
            }
        }
        return tmpChar;
    }
}
