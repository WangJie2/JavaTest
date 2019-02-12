package wj.test;

import org.junit.Test;
import wj.other.Employee;

import java.util.*;

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
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==1)
//                iterator.remove();
                list.remove(1);
        }

    }
    
}