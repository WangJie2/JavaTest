package wj.test;

import org.junit.Test;

import java.io.Serializable;
import java.util.Hashtable;

public class B implements Serializable {

    private String name;

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = new String("abc");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(d == c);
        System.out.println(d.equals(c));
        Hashtable dd = new Hashtable();
        dd.put(null,"ss");
        System.out.println(dd.get(null));

    }

    public void getName() {
        System.out.println("bbbbb=============");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void test4() {
        System.out.println("4");
    }
}

