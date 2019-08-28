package wj.test;

import org.junit.Test;
import wj.other.Employee;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class FinallyTest1 {

    public static void main(String[] args) throws Exception {
        Employee employee = new Employee("测试");
        B b=new B();
        b.setName("test");
        employee.setB(b);
        Object clone = employee.clone();
        Object clone1 = employee.deepClone();
        System.out.println(test1());
    }

    public static int test1() {
        int b = 20;
        List s = new ArrayList();
        Set set = new HashSet();
        String ss = "";
        ss.length();
        String[] sss = {};
        int length = sss.length;


        try {
            System.out.println("try block");

//            return b += 80;
        }
        catch (Exception e) {

            System.out.println("catch block");
        }
        finally {
            
            System.out.println("finally block");
            
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            b=1;
//            return b;
        }
        
        return 111;
    }
    @Test
    public void test2() throws InterruptedException {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers =
                new ArrayList<>(Arrays.asList(intArray));
        List<Integer> parallelStorage = new ArrayList<>();//Collections.synchronizedList(new ArrayList<>());
        listOfIntegers
                .parallelStream()
                // Don't do this! It uses a stateful lambda expression.
                .map(e -> {
                    parallelStorage.add(e);
                    return e;
                })
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Sleep 5 sec");
        TimeUnit.SECONDS.sleep(5);
        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));


    }

    @Test
    public void test3() throws InterruptedException {
//创建集合大小为100
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            integers.add(i);
        }

        //多管道遍历
        List<Integer> integerList = new ArrayList<>();
        integers.parallelStream().forEach(e -> {
            //添加list的方法
            synchronized (this.getClass()){

                integerList.add(e);
            }
            try {
                //休眠100ms，假装执行某些任务
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println(integerList.size());
    }
    @Test
    public void test4(){
        try {
            //休眠100ms，假装执行某些任务
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    
}