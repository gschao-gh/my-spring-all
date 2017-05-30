package com.testweb.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal 实现原理
 * Created by Administrator on 2017/5/30.
 */
public class SimpleThreadLocal<T> {
    private Map valeMap = Collections.synchronizedMap(new HashMap());

    public void set(T newValue){
        valeMap.put(Thread.currentThread(),newValue);
    }

    public T get(){
        Thread currentThread = Thread.currentThread();
        T o = (T) valeMap.get(currentThread);
        if(o==null&&!valeMap.containsKey(currentThread)){
            o = initvalValue();
            valeMap.put(currentThread,o);

        }
        return o;
    }

    protected T initvalValue(){
        return null;
    }

}
