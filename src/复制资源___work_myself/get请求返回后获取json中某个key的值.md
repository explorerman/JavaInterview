http中get请求后，如何得到json格式的数据，和某个key的值

使用JSONObject.fromObject得到JSON对象

然后可以get其中的key，来获取对应的value

如需重组，则可以重新组织map，用于返回

```java
 /**
     * 功能描述
     *
     * @param *    @param jsonStr
     * @param keys
     * @return {@link java.lang.String}
     * @name 用于返回json中的值，通过key，匹配value
     * keys为键，定为可变长度用于匹配key
     * 例如：
     * {
     * "errCode": 0,
     * "errMsg": "ok",
     * "data":{
     * "name": "张三",
     * "mobilePhone":
     *	 {
     * 		"countryCode": "86",
     * 		"number": "12345678902"
     *	 },
     * }
     * }
     * keys:errCode ; 返回的值为:0
     * keys:data, name ; 返回的值为：张三
     * keys:data, mobilePhone, number; 返回的值为 12345678902
     * @createTime: 2020/9/7 19:40
     * @author 李杰
     * @history 修订历史（历次修订内容、修订人、修订时间等）
     */
    private String readJsonValue(String jsonStr, String... keys) {
        for (int i = 0; i < keys.length; i++) {
            if (StringUtils.isBlank(jsonStr)) {
                return "";
            }
            //JSONObject.fromObject(jsonStr)转成了JSON格式，其中JSONOject是json中的方法，将对象转成JSON格式
            //然后getString用于获取key对应的value
            jsonStr = JSONObject.fromObject(jsonStr).getString(keys[i]);
            if (i == keys.length - 1) {
                return jsonStr;
            }
        }
        return "";
    }

 public static void main(String[] args) {
        String url = "xxx";
        String jsonStr = HttpUtil.doGet(url);
        String result = new LxOauthService().readJsonValue(jsonStr, "data", "appToken");
        System.out.println(result);
    }
```

