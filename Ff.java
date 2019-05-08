package wj.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangJie on 2019/4/8.
 */
public class Ff {

    private static List<Integer> l;

    static {
        l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println("初始化完成");
    }

    public static List<Integer> getL() {
        return l;
    }

    public static void setL(List<Integer> l) {
        System.out.println("shezhi");
        Ff.l = l;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
