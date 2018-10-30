package wj.test;

/**
 * Created by WangJie on 2018/5/23.
 */
public class SubClass  implements SupFunction,SuperFunction{
    public static void main(String[] args) {
        SupFunction subClass=new SubClass();
        System.out.println( subClass.test());

    }

    @Override
    public String test() {
        return "ssss";
    }
}
