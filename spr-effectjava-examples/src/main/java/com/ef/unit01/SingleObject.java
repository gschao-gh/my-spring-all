package com.ef.unit01;

/**
 * Created by Administrator on 2017/2/25.
 * 用私有构造器或者枚举类型强化single属性
 */
public class SingleObject {
    /**
     * 第一种实现方法
     * 私有构造类
     */
    public static  class Elvis{
        public static final Elvis INSTANCE = new Elvis();
        private Elvis(){}

    }

    /**
     * 防止客户端使用反射机制构造对象
     */
    public static class Elvis2{
        public static final Elvis2 INSTANCE = new Elvis2();
        private Elvis2(){}
        //防止反射调用生成对象
        public static Elvis2 getInstance(){
            return INSTANCE;
        }
        //防止反序列化时创建新的对象
        public Object readResolve(){
            return INSTANCE;
        }

    }


    /**
     * 从1.5之可以有第三种实现单例的方式，包含单个元素的枚举类
     * 最佳方法
     * 提供序列化
     * 更加简洁
     * 在反射和序列化时也可保证单例
     */
    public enum ElvisEmum{
        INSTANCE;
        public void leaveTheBuilding(){

        }
    }






}
