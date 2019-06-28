package com.wangyue;

import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public void test () {
        String url = "https://api.seniverse.com/v3/weather/now.json?key=smtq3n0ixdggurox&location=beijing&language=zh-Hans&unit=c";
        String getResult = HttpClientAction.getInstance().get(url);
        System.out.println(getResult);

        String url2 = "https://api.seniverse.com/v3/weather/now.json";
        Map<String, String> params = new HashMap<>();
        params.put("key", "smtq3n0ixdggurox");
        params.put("location", "sanming");
        params.put("language", "zh-Hans");
        params.put("unit", "c");
        String getResult2 = HttpClientAction.getInstance().getByMap(url2, params);
        System.out.println(getResult2);
    }
}
