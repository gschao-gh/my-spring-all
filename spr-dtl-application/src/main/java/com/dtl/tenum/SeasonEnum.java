package com.dtl.tenum;

/**
 * Created by Administrator on 2016/11/28.
 * JSEE1.5添加enum关键字定义枚举类
 * 枚举类是一种特殊的类
 * 可以有自己的方法和属性，可以有一个或者多个构造器。一个Java文件只可以有一个public的枚举类
 * Java源文件要同public修饰的枚举类名相同
 * 枚举类可以实现一个或者多个接口，使用enum定义的枚举类默认继承了java.lang.Enum类，而不是继承Object类
 * java.lang.Enum类默认实现java.lang.Serializable和java.lang.Comparable两个接口
 * 构造器只能使用private修饰符，默认使用private修饰
 * 枚举类的实例必须必须在类中显式列出，枚举类永远不会在创建实例。默认添加 public static final,无需程序显式添加
 * 所有枚举类默认添加values方法，用于列举出所有的枚举值；
 *
 */
public enum SeasonEnum  {
   SPRING,SUMMER,FALL,WINTER;
}
