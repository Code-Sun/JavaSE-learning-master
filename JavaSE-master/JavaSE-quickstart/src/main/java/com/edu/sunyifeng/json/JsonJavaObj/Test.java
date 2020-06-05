package com.edu.sunyifeng.json.JsonJavaObj;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu.sunyifeng.Utils.TimeUtil;

public class Test {
    public static void main(String[] args) throws Exception {
        JSONObject json = JSONObject.parseObject("{'birthday':1591335984,'name':'哈哈'}");

        // json字符串的个数小于对象属性个数，也可以转换
        Person p1 = JSON.toJavaObject(json,Person.class);
        System.out.println(p1.getId()+"=="+p1.getName()+"=="+p1.getBirthday());

        // 修改生日格式后，更新生日，再讲json转为java对象
        Long birthdayL = json.getLong("birthday");
        String birthday = TimeUtil.secondToDate(birthdayL, TimeUtil.yyyyMMddHHmmss);
        json.put("birthday",birthday);
        json.put("id",1);
        Person p2 = JSON.toJavaObject(json,Person.class);
        System.out.println(p2.getId()+"=="+p2.getName()+"=="+p2.getBirthday());


    }

}
