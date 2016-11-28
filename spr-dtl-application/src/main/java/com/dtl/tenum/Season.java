package com.dtl.tenum;

/**
 * Created by Administrator on 2016/11/28.
 */
public class Season {
    private final String name;
    private final String describe;

    private Season(String name,String describe){
        this.describe = describe;
        this.name = name;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","烈日炎炎");
    public static final Season FALL = new Season("秋天","秋风扫落叶");
    public static final Season WINTER = new Season("冬天","白雪皑皑");


    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
