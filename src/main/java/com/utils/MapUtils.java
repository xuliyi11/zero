package com.utils;

import com.domain.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xly on 2018/4/21.
 */

public class MapUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    /**
     *判断对象为String类型并且不是空字符串
     * @param o
     */
    public static void judgeStringNotNull(Object o) throws Exception {
        if (o == null || !(o instanceof String) || StringUtils.isBlank((String)o)){
            throw new Exception("param not String or param null");
        }
    }

    public static final Map<String,Object> string2Map( String string) throws IOException {
        return objectMapper.readValue(string, new TypeReference<HashMap<String,Object>>() {});
    }

    public static final List<User> string2List(String string) throws IOException {
        return objectMapper.readValue(string, new TypeReference<List<Object>>() {});
    }
}
