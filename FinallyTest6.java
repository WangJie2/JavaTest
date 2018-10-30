package wj.test;

import java.util.HashMap;
import java.util.Map;

public class FinallyTest6
{
    public static void main(String[] args) {
        System.out.println(getMap().size());
    }
     
    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("KEY", "INIT");
         
        try {
            map.put("KEY", "TRY");
            return map;
        }
        catch (Exception e) {
            map.put("KEY", "CATCH");
        }
        finally {
            map.put("KEY", "FINALLY");
            map = new HashMap<>();
            map.put("1", "2");
            map.put("2", "3");
            return map;
        }
         
//        return map;
    }
}