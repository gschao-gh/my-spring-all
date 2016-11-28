package com.dtl.enumtest;

import com.dtl.tenum.Season;

/**
 * Created by Administrator on 2016/11/28.
 */
public class SeasonTest {

    public void  testSeason(Season season){
        System.out.println(season.getName()+"里"+season.getDescribe());

    }

    public static void main(String[] args) {
        new SeasonTest().testSeason(Season.SPRING);
    }

}
