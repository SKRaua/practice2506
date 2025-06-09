package com.cqupt.pojo;

/**
 * @author Zhou Xinyang
 * @version 1.0
 */
public class ExTest {
    public static void main(String[] args) throws Exception {
        // ExTest test = new ExTest();
        // try {
        // test.validateAge(-1);
        // } catch (Exception e) {
        // // throw new RuntimeException(e); //抛出异常，使得程序能够及时终止，不抛出异常则程序会正常执行
        // // System.out.println("捕获了异常"+e.getMessage()); //捕获了异常age couldn't be
        // negative.
        // // System.out.println("捕获了异常"+e.toString());
        // // 捕获了异常java.lang.IllegalArgumentException: age couldn't be negative.
        // // System.out.println("捕获了异常"+e.getLocalizedMessage()); //捕获了异常age couldn't
        // be
        // // negative.
        // e.printStackTrace(); // 打印的异常信息就等同于test.validateAge(-1);打印出的信息
        // e.printStackTrace(System.err); // 打印出的字体是红色的
        // e.printStackTrace(System.out); // 打印出的字体是白色的
        // // e.printStackTrace和finally执行是异步的
        // } finally {
        // System.out.println("不管怎么样,最后一步都要执行");
        // }

        // test.solve(); // alt+enter

    }

    // 验证年龄数值是否合法
    void validateAge(int age) {
        if (age < 0) {
            // 方法参数不合法异常
            throw new IllegalArgumentException("age couldn't be negative.");
        } else if (age > 120) {
            throw new IllegalArgumentException("age couldn't be greater than 120.");
        }
    }

    // 解决方法
    void solve() throws Exception {
        validateAge(-1);
    }
}
