package LeetCode_review_2;

import java.util.HashMap;
import java.util.Map;

//url匹配
//
//函数的参数：url 表示一个网址，params 表示一个参数列表
//
//函数的功能：如果 param 中的参数在 url 中存在，则什么也不做，如果不存在，添加到 url 中
//
//举例： url http://ab.com/a/b/c?a=b&c=d&e=f#swwda=x params c: h a: b y: d
//
//return http://ab.com/a/b/c?a=b&c=d&e=f&y=d#swwda=x
public class urlExample {
    String process(String url, Map<String,String> params) {
        String res = "";
        if(params.size() == 0) return url;
        for (Map.Entry<String, String> vo : params.entrySet()){
            if(url.contains(vo.getKey())){
                continue;
            }else{
                res = appendUrl(url, vo);
            }
        }
        System.out.println(res);
        return res;
    }

    private String appendUrl(String url, Map.Entry<String, String> vo) {
        final int index = url.indexOf("#");
        StringBuilder sb = new StringBuilder(url);
        sb.insert(index, "&" +vo.getKey()+"=" + vo.getValue());
        return sb.toString();
    }

    public static void main(String[] args) {
        String url = "http://ab.com/a/b/c?a=b&c=d&e=f#swwda=x";
        HashMap<String,String> map = new HashMap<>();
        map.put("c","h");
        map.put("a","b");
        map.put("y","d");
        new urlExample().process(url,map);
    }
}
