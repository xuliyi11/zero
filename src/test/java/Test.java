import com.alibaba.fastjson.JSON;
import com.domain.User;
import com.lowagie.text.html.HtmlTagMap;
import org.apache.commons.collections4.CollectionUtils;

import javax.json.Json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xly on 2018/4/21.
 */
public class Test {
    public static void main(String[] args) {
        Map<String,Object> inMap = new HashMap<String,Object>(){{
            put("hashMap", new HashMap<String,Object>(){{
                put("key","value");
            }});
        }};
        User user = new User(){
            {
                setId(1);
                setUserAge("sss");
            }
        };
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(user));

     }
}
