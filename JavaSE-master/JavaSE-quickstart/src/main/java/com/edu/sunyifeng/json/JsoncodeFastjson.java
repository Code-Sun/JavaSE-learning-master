package com.edu.sunyifeng.json;

import cn.miludeer.jsoncode.JsonCode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsoncodeFastjson {

    /*
    要解析的json结构

    {
        "json": {
            "a": {
                "www": "ff",
                "rrr": ["v1", "v2"]
            },
            "b": {
                "www": "4567ttt",
                "rrr": ["v1", "v2"]
            }
        }
    }
     */


    private static String json = "{\"json\":{\"a\":{\"www\":\"ff\",\"rrr\":[\"v1\",\"v2\"]},\"b\":{\"www\":\"4567ttt\",\"rrr\":[\"v1\",\"v2\"]}}}";

    // 使用fastjson
    public static String usefastjson() {
        JSONObject ob = JSON.parseObject(json).getJSONObject("json").getJSONObject("b");
        return ob.getString("www");
    }

    // 使用jsoncode
    public static String usejsoncode() {
        String ret = JsonCode.getValue(json, "$.json.b.www");
        return ret;
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        for(int i=0; i<10000000;i++) {
            usejsoncode();
        }
        long time2 = System.currentTimeMillis();
        for(int i=0; i<10000000;i++) {
            usefastjson();
        }
        long time3 = System.currentTimeMillis();

        System.out.println("fastJson:" + (time3 - time2));
        System.out.println("jsoncode:" + (time2 - time1));
    }

}
