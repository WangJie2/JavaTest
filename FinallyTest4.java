package wj.test;

public class FinallyTest4 {

    public static void main(String[] args) {

        System.out.println(test4());
    }

    public static int test4() {
        int b = 20;

        try {
            System.out.println("try block");

            b = b / 0;

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
            return b += 15;
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return b += 50;
        }

//        return b;
    }

}