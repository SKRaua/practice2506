package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
 * @author Zhou Xinyang
 */
@Component // 要将方法放到IoC容器中
@Aspect
public class MyAdvice {

    // 需要提供一个切入点
    // 目标类中的每一个方法都是一个连接点
    // 切入点表达式
    // @Pointcut("execution(void org.example.dao.impl.BookDAOImpl.save())")
    @Pointcut("execution(* org.example.dao.impl.BookDAOImpl.*())")
    // @Pointcut("execution(void org.example.dao.*.*())")
    public void pointcut() {
    }

    // @Before("pointcut()") //导航代码到pointcut执行之前
    // @After("pointcut()")
    public void computeTime() {
        long start = System.currentTimeMillis(); // 记录开始的时间
        for (int i = 0; i < 100000; i++) { // 计算业务执行万次的时间
            System.out.println("执行业务...");
        }
        long end = System.currentTimeMillis(); // 记录结束的时间
        System.out.println("业务执行十万次时间:" + (end - start) + "ms");
    }

    // 环绕通知会与原始方法进行争抢
    @Around("pointcut()")
    public Integer around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知：");
        long start = System.currentTimeMillis();
        Integer ret = 0;
        for (int i = 0; i < 100000; i++) {
            // 直接在中间执行切入点方法
            ret = (Integer) joinPoint.proceed();
            ;
            // System.out.println("正在执行业务中...");
        }
        long end = System.currentTimeMillis();
        System.out.println("业务执行十万次时间：" + (end - start) + "ms。");
        return ret;
    }

}
