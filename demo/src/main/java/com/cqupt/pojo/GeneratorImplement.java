package com.cqupt.pojo;


//不是泛型的实现类
//public class GeneratorImplement implements Generator<String> {
//    @Override
//    public String method() {
//        return "我是String类型实现类";
//    }
//}

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class GeneratorImplement<T> implements Generator<T> {
    @Override
    public T method() {
        return null;
    }
}
