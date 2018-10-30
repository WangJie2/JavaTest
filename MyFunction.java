package wj.test;

/**
 * Created by WangJie on 2018/5/22.
 */
@FunctionalInterface
public interface MyFunction {
    void study();

    default void teacher() {
        System.out.println("Hello");
    }

    boolean equals(Object obj);

    static void test(){
        System.out.println("test");
    }

}
