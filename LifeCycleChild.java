package wj.test;

public class LifeCycleChild extends LifeCycle{
    // 静态方法块
    // 静态属性
    private static String name = getName();
    static {
        System.out.println(name);
        System.out.println("子类静态方法块初始化");
        System.out.println("Static Patch Initial");
    }
    // 普通属性
    private String field = getField();
    // 普通方法块
    {
//        System.out.println(field);
        System.out.println("子类普通方法块初始化");
        System.out.println("Field Patch Initial");
    }
    // 构造函数
    public LifeCycleChild() {
        System.out.println("子类构造函数初始化");
        System.out.println("Structure Initial ");
    }

    public static String getName() {
        String statiFiled = "Static Field Initial";
        System.out.println("子类静态属性初始化");
        return statiFiled;
    }

    public static String getField() {
        String filed = "Field Initial";
        System.out.println("子类普通属性初始化");
        return filed;
    }   
    // 主函数
    public static void main(String[] argc) {
        new LifeCycleChild();
    }
}