package com.cqupt;

import com.cqupt.pojo.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();

        // 方法的重载
        Book book = new Book();
        book.printBook();
        book.printBook("计算机网络", "谢希仁");

        // 方法的重写
        System.out.println(book.toString());

        // test5();

        // 类的继承
        // Person person = new Person();
        // Student student=new Student();
        // Person student1=new Student();
        // //人的活动
        // System.out.println("人的活动");
        // person.eat();
        // person.sleep();
        // System.out.println("-----------------------------");
        // //学生的活动
        // System.out.println("学生的活动");
        // student.eat(); //继承父类
        // student.sleep();
        // student.learn();
        // //student1.learn(); //此处student1调用learn方法会报错，多态不能调用只在子类中存在但在父类中不存在的方法
        // System.out.println("-----------------------------");
        // //类的封装
        // System.out.println("人的名字: "+person.getName());
        // System.out.println("学生的名字: "+student.getName()); //无法直接获取对象的private属性
        // System.out.println("学生1的名字: "+student1.getName());
        // //在Student类中重写了getName,返回的是Student中的name,而不是Person中继承的默认值
        // System.out.println("-----------------------------");

        // String,StringBuilder,StringBuffer
        // String是不可变的对象,每次改变String的值都会新建一个对象但StringBuilder,StringBuffer可变
        // String str=new String("hello");
        // StringBuilder sbuilder=new StringBuilder("aaa");
        // StringBuffer sbuffer=new StringBuffer("bbb");

        // String s1="hello ";
        // String s2="world";
        // String s3="!!!";
        // String s4=s1+s2+s3; //拼接最好使用StringBuilder和StringBuffer
        // System.out.println(s4);
        // System.out.println(s1.equals(s2)); //比较字符串使用equals

        // 泛型
        // ArrayList<E>或ArrayList<T>
        // ArrayList<Integer>list1=new ArrayList();
        // ArrayList<String>list2=new ArrayList();
        // list1.add(11); //传入的参数必须与泛型接口规定的类型相对应
        // list2.add("11");

        // 自定义泛型类
        // Generic<Integer>g1=new Generic<Integer>(123);
        // System.out.println(g1.getKey());
        //
        // Generic<String>g2=new Generic<String>("str");
        // System.out.println(g2.getKey());

        // 自定义泛型接口
        // GeneratorImplement gl=new GeneratorImplement();
        // System.out.println(gl.method());

        // 反射类 在没有定义getter时用于获取已经封装好的类中的属性
        Student st = new Student("张三", 18, "男");
        // System.out.println(st.getName()); //通过getter获取姓名
        RefectionTest rt = new RefectionTest();
        String na = (String) rt.getField(st, "name"); // 此处返回的是Object类型，需要强转
        System.out.println("修改前:" + na);
        rt.setField(st, "name", "李四");
        na = (String) rt.getField(st, "name"); // 修改以后需要重新获取名字
        System.out.println("修改后:" + na);
    }

    // 测试位运算符
    public static void test1() {
        int i = -1;
        System.out.println("初始变量数值:" + i);
        System.out.println("初始二进制数值:" + Integer.toBinaryString(i));

        i <<= 10;
        System.out.println("左移10位后的数值:" + i);
        System.out.println("左移10位后的二进制数值:" + Integer.toBinaryString(i));

        i >>= 10;
        System.out.println("右移10位后的数值:" + i);
        System.out.println("右移10位后的二进制数值:" + Integer.toBinaryString(i));
    }

    // 展示包装类
    public static void test2() {
        // Integer.valueOf() 发生自动装箱
        Integer i1 = 40;
        Integer i2 = new Integer(40); // 此种写法过时了,使用valueOf是更好的选择,因此报错
        Integer i3 = Integer.valueOf(40);
        System.out.println(i1 == i2); // false
        System.out.println(i1 == i3); // true

        System.out.println(i1.equals(i2)); // 包装类比较数值使用equals方法,直接==比较的是对象地址
    }

    // 测试浮点数精度问题
    // 计算机存储无限循环的小数会被截断,会发生精度损失的情况
    public static void test3() {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("a是否等于b:" + (a == b));
    }

    // 解决精度丢失问题
    // 使用BigDecimal类
    public static void test4() {
        BigDecimal a = new BigDecimal("2.0");
        BigDecimal b = new BigDecimal("1.9");
        BigDecimal c = new BigDecimal("1.8");
        BigDecimal d = new BigDecimal("1.7");
        BigDecimal f = new BigDecimal("2.00");

        BigDecimal x = a.subtract(b); // x=a-b
        BigDecimal y = c.subtract(d); // y=c-d
        System.out.println(Objects.equals(x, y)); // Objects.equals()比较的是内容
        System.out.println(x.compareTo(y)); // compareTo返回0表示数值相同

        BigDecimal z = f.subtract(b); // z=f-b
        System.out.println(Objects.equals(x, z)); // 比较a-b和f-b 0.10和0.1 内容不同
        System.out.println(x.compareTo(z));
    }

    // 创建对象
    public static void test5() {
        String str1 = "hello";
        String str2 = new String("hello"); // 通过new创建的对象，若在常量池中存在hello,则只创建1对象，否则会在常量池中创建hello对象，在栈区中创建new对象，总共2个对象
        String str3 = "hello";

        // ==符号比较的是引用是否相等，即对象存储的地址
        System.out.println(str1 == str2); // false 通过new创建的对象会创建在堆中
        System.out.println(str1 == str3); // true 常量会存到栈区的常量池

        // 使用equals比较的是内容是否相等
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1.equals(str3)); // true

    }
}
