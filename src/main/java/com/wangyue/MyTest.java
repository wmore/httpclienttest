package com.wangyue;

import com.wangyue.http.HttpClientUtils;

public class MyTest {
    public void test () {
     /*   String url = "https://api.seniverse.com/v3/weather/now.json?key=smtq3n0ixdggurox&location=beijing&language=zh-Hans&unit=c";
        String getResult = HttpClientUtils.getInstance().get(url);
        System.out.println(getResult);

        String url2 = "https://api.seniverse.com/v3/weather/now.json";
        Map<String, String> params = new HashMap<>();
        params.put("key", "smtq3n0ixdggurox");
        params.put("location", "sanming");
        params.put("language", "zh-Hans");
        params.put("unit", "c");
        String getResult2 = HttpClientUtils.getInstance().getByMap(url2, params);
        System.out.println(getResult2);*/


        String url = "E:/对接cas/三峡大学/GetDepartment.html";
        String getResult = HttpClientUtils.getInstance().get(url);
        System.out.println(getResult);

    }
}
