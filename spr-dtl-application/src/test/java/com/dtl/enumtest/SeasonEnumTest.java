package com.dtl.enumtest;

import com.dtl.tenum.SeasonEnum;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SeasonEnumTest {

    public void judge(SeasonEnum se){
        switch (se){
            case SPRING:
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎");
                break;
            case FALL:
                System.out.println("秋风扫落叶");
                break;
            case WINTER:
                System.out.println("白雪皑皑");
                break;
        }

    }


    public static void main(String[] args) {
        for (SeasonEnum se:SeasonEnum.values() ) {
            System.out.println(se.toString());
        }
        new SeasonEnumTest().judge(SeasonEnum.SPRING);
    }



}
