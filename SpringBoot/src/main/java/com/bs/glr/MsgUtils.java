package com.bs.glr;

import com.bs.glr.bean.HttpUtils;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;


public class MsgUtils {
    public static Boolean sendMsg(String phone) {
        String host = "http://yzxtz.market.alicloudapi.com";
        String path = "/yzx/notifySms";
        String method = "POST";
        String appcode = "6d8a9ac9655a4623a2b21b8d2df2d1fc";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("phone", phone);
        querys.put("templateId", "TP18040316");
        querys.put("variable", "num:1234,money:888");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            String resu = response.toString();
            System.out.println(resu);
            if(resu.indexOf("00000")>0){
                return true;
            }
            return false;
//            System.out.println();
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
