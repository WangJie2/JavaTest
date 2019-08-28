package wj.test;

import org.junit.Test;
import sun.misc.Launcher;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by WangJie on 2018/10/9.
 */
public class Test1 {
    public static void main(String[] args) {

        //代码1
        String sa = "ab";
        String sb = "cd";
        String sab = sa + sb;
        String s = "abcd";
        System.out.println(sab == s); // false
//代码2
        String sc = "ab" + "cd";
        String sd = "abcd";
        System.out.println(sc == sd); //true

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

    @Test
    public void test3() throws UnsupportedEncodingException {
        System.out.println("3");
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
//编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }

    @Test
    public void test4() {
        System.out.println("4");
        String regex = "123|666";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("123456");
        boolean matches = m.matches();
        boolean b = m.find();
        List<Integer> s = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            s.add(i);
        }
        List ss = s.stream().skip(5).limit(2).collect(Collectors.toList());
        System.out.println("");

    }

    @Test
    public void test5() {
//        List<Integer> j = new ArrayList<>();
//        j.add(500);
//        j.add(501);
//        j.add(502);
////        Ff f = new Ff();
//        Ff.setL(j);
//        System.out.println(Ff.getL().toString());
       /* try {
            Class<?> aClass = Class.forName("wj.test.Ff");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
      /*  System.out.println("start");
        Singleton instance = Singleton.getInstance();
        System.out.println("start1");
        Singleton instance1 = Singleton.getInstance();
        System.out.println("start2");*/
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            l.add(i);
        }
//        System.out.println(9/0);
        for (Integer integer : l) {

            System.out.println(l.get(1).doubleValue());
        }
    }

    @Test
    public void test6() {
        String a = "计算";
        String b = "机";
        String c = a + b;
        String s1 = new String("计算机");
        System.out.println(s1.intern() == s1);
//        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(c.intern() == s3.intern());
        System.out.println(c == s3);
      /*  System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的String对象一个是常量池中的String对象，
        System.out.println(s3.intern() == s2);//true，因为两个都是常量池中的String对

        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false*/

    }

    @Test
    public void test7() {
       /* String s1 = new String("算")+new String("机");
//        s1.intern();
        String d="算机";
//        StringBuilder builder = new StringBuilder("算");
//        String s1= builder.append("机").toString();
        System.out.println(s1 == d);*/
        String s = "ag" + "h";
        s = s + "a" + "g";
//        String s = new String("ag") + new String("b");
        String a = new StringBuilder("ag").append("h").toString();
        System.out.println(a.intern() == a);

    }

    @Test
    public void test8() {
        ClassLoader classLoader = Launcher.class.getClassLoader();
        System.out.println("");
    }

    @Test
    public void test9() {
        String name1 = "abcd";
        String name2 = "abcd";
        System.out.println("执行结果：" +( name1 == name2));
    }

    @Test
    public void test10() {
        List<List<String>> f = new ArrayList<>();
        List<String> c = new ArrayList<>();
        c.add("before");
        f.add(c);
        c.add("after");
        System.out.println(f.toString());


    }

}

