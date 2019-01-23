package wj.test;

import org.junit.Test;

/**
 * Created by WangJie on 2018/10/9.
 */
public class Test1 {
    public static void main(String[] args) {

        //代码1
        String sa = "ab";
        String sb = "cd";
        String sab=sa+sb;
        String s="abcd";
        System.out.println(sab==s); // false
//代码2
        String sc="ab"+"cd";
        String sd="abcd";
        System.out.println(sc==sd); //true

        String s3 = new String("2") + new String("2");
        String s4 = "22";        // 常量池中不存在22，所以会新开辟一个存储22对象的常量池地址
        s3.intern();    // 常量池22的地址和s3的地址不同
        System.out.println(s3 == s4); // false
    }

    @Test
    public void test1() {
        System.out.println("1");
    }

    @Test
    public void test2() {
        System.out.println("2");
    }
}

