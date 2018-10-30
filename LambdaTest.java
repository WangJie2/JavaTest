package wj.test;

import org.junit.Test;
import wj.other.Employee;

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.function.*;

/**
 * Created by WangJie on 2018/5/21.
 */
public class LambdaTest {

    @Test
    public void test1() {
        //java8以前写法
        Supplier<Employee> supplier1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        //lambda表达式
        Supplier<Employee> supplier2 = () -> new Employee();
        //lambda结合构造引用
        Supplier<Employee> supplier3 = Employee::new;


        Employee employee = new Employee();
        //完整表达式
        Consumer<Employee> consumer = (Employee o) -> {
            System.out.println(this);
            o.setNo(o.getName());
        };
        consumer.accept(employee);
        //数据类型可忽略，编译器可推断出
        //方法体只有一行代码时，可忽略大括号
        Consumer<Employee> consumer1 = (o) -> o.setNo(o.getName());
        //只有一个参数时可忽略小括号
        Consumer<Employee> consumer2 = o -> o.setNo(o.getName());

        int num = 9;
        Consumer<Employee> consumer3 = employee1 -> employee1.setAge(num);
        consumer3.accept(employee);
        System.out.println(employee);
    }

    @Test
    public void test2() {
        //消费型接口
        Consumer<Employee> consumer = employee -> employee.setDept("test");
        //供给型接口
        Supplier<Employee> supplier = () -> new Employee();
        //函数型接口
        Function<String, Employee> function = name -> new Employee(name);
        //断定型接口
        Predicate<Employee> predicate = employee -> employee.getAge() > 18;

        Employee emp = function.apply("测试");
//        Employee emp = supplier.get();
        consumer.accept(emp);
        System.out.println(emp);
        System.out.println(predicate.test(emp));
    }

    @Test
    public void test3() {
        //1.对象::实例方法
        Consumer<String> con = x -> System.out.println(x);
        //前提条件: Consumer中的方法体参数与返回值要与ps.println方法中的参数和返回值类型相同
        //Consumer： void accept(T t);在这里T为String
        //PrintStream:  public void println(String x)
        //两者传入的参数都为String,返回值都为void所以满足，可以使用方法引用
        Consumer<String> con1 = System.out::println;
        con.accept("test");
        con1.accept("test1");

        //2.类::静态方法名
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        //前提条件:和上面相同
        //public static int compare(int x, int y)
        // int compare(T o1, T o2);在这里T为Integer
        Comparator<Integer> com1 = Integer::compare;

        //3.类::实例方法名
        String st1 = "test";
        String st2 = "test";
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test(st1, st2));
        //前提:第一个参数是实例方法的调用者，第二个参数是实例方法的参数(或无参)
        //例如 x 是equal方法的调用者，y是实例方法的参数
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test(st1, st2));
        //无参
        Function<String, String> function = s -> s.toUpperCase();
        System.out.println(function.apply(st1));
        Function<String, String> function1 = String::toUpperCase;
        System.out.println(function1.apply(st1));
    }

    @Test
    public void test4() {
        //构造应用
        //供给型接口
        Supplier<Employee> supplier = () -> new Employee();
        Supplier<Employee> supplier1 = Employee::new;

        //函数型接口
        Function<String, Employee> function = name -> new Employee(name);
        Function<String, Employee> function1 = Employee::new;

        //数组引用
        Function<Integer, String[]> fun = x -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun1 = String[]::new;
        strs = fun1.apply(20);
        System.out.println(strs.length);
    }

    @Test
    public void test5() throws UnsupportedEncodingException {
        String s = "g";
//        System.out.println(s.getBytes("UTF-8").length);
//        System.out.println(s.getBytes("GBK").length);


        System.out.println(Byte.BYTES);
//        System.out.println(Character.BYTES);

        System.out.println(Short.BYTES);
        System.out.println(Character.BYTES);

        System.out.println(Integer.BYTES);
        System.out.println(Float.BYTES);

        System.out.println(Long.BYTES);
        System.out.println(Double.BYTES);


    }

    public static int getSum(int n, int m) {
        if (m <= n) {
            return n;
        }
        return m + getSum(n, m-1);
    }

    @Test
    public void test6(){
        System.out.println(getSum(1,-1));
    }
}
