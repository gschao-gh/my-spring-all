package com.spr.upload.struts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gschao
 * @date 2016/12/2 14:11.
 * 我的json测试对象
 */
public class MyJsonBean {
    private int counter;
    private List<String> names;


    public MyJsonBean(){
        counter = 0;
        names = new ArrayList<String>();
    }

    public MyJsonBean(int counter,List<String> names){
        this.counter = counter;
        this.names = names;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
