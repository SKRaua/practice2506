package com.cqupt.pojo;

import java.lang.reflect.Field;

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class RefectionTest {
    // 获取属性
    public Object getField(Object obj, String fieldName) {
        try {
            // 1.获取obj对象的class对象
            Class<?> objClass = obj.getClass();
            // 2.获取指定名称字段
            // Field field=objClass.getField(fieldName); //getField只能获取public的属性
            Field field = objClass.getDeclaredField(fieldName); // 任何属性都能够获取
            // 3.设置字段方法可以访问
            field.setAccessible(true);
            // 4.获取字段的值并返回
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException("无法获得字段" + fieldName + " " + e);
        }

    }

    // 设置属性
    public void setField(Object obj, String fieldName, Object value) {
        try {
            // 1.获取obj对象的class对象
            Class<?> objClass = obj.getClass();
            // 2.获取指定名称的字段
            Field field = objClass.getDeclaredField(fieldName);
            // 3.设置字段方法可以访问
            field.setAccessible(true);
            // 4.修改字段的值
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException("无法获取字段" + fieldName + " " + e);
        }
    }

}
