package leetcode_list;

public class number4 {
    public static void main(String[] args) {
        //将int转换为string进行操作。
        int x = -100;
        String str = String.valueOf(x);
        int strLength = str.length();
        if(x >= 0){
            StringBuilder sb = new StringBuilder(str);
            if(sb.lastIndexOf("0") == strLength - 1){
                sb.substring(0, strLength - 2);
                if(sb.lastIndexOf("0") == strLength - 2){
                    sb.substring(0, strLength -3);
                    System.out.println(Integer.valueOf(sb.reverse().toString()));
                }
                System.out.println(Integer.valueOf(sb.reverse().toString()));
            }else{
                System.out.println(Integer.valueOf(sb.reverse().toString()));
            }
        }
        if(x < 0) {
            StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(0);
                if (sb.lastIndexOf("0") == strLength - 1) {
                    sb.substring(1, strLength - 2);
                    if (sb.lastIndexOf("0") == strLength - 2) {
                        sb.substring(1, strLength - 3);
                        System.out.println(Integer.valueOf(sb.reverse().insert(0, "-").toString()));
                    }
                    System.out.println(Integer.valueOf(sb.reverse().insert(0, "-").toString()));
                } else {
                    System.out.println(Integer.valueOf(sb.reverse().insert(0, "-").toString()));
                }
            }
        }
    }

