package wj.test;

import wj.other.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
}