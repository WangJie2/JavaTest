package wj.test;

/**
 * Created by WangJie on 2018/5/23.
 */
public interface SuperFunction {
    default String test() {
        return "SuperFunction";
    };
}
