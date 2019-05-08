package wj.test;

import org.junit.Test;

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
        LifeCycleChild c = new LifeCycleChild();
    }
}

