package wj.test;

/**
 * Created by WangJie on 2018/11/14.
 */
public class TestUtil {
    private String name;

    private TestUtil() {
        throw new RuntimeException("不能初始化！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
