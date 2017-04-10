package comapp.example.gyq.mvp.Contract;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数的拼接
 */
public final class ParameterMap {

    private static volatile Map<String, String> map = null;
    private static volatile ParameterMap parametermap;

    static {
        if (null == map) {
            synchronized (ParameterMap.class) {
                map = new HashMap<>();
                parametermap = new ParameterMap();
            }
        }
    }


    private ParameterMap() {
    }

    public static ParameterMap put(String key, String value) {
        map.put(key, value);
        return parametermap;
    }


    public static ParameterMap remove(String key) {
        map.remove(key);
        return parametermap;
    }


//    public static ParameterMap putAll(Map map) {
//        map.putAll(map);
//        return parametermap;
//    }


    public static ParameterMap clear() {
        map.clear();
        return parametermap;
    }


    public Map<String, String> getMap() {
        return map;
    }

}
