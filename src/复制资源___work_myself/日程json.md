## 横坐标：全部领导,纵坐标：一周

如下格式适合于：左侧全部领导,上侧为一周时间（周一-周日）

|      | 周一      | 周二      | 周三      | 周四      | 周五      | 周六 | 周日 |
| ---- | --------- | --------- | --------- | --------- | --------- | ---- | ---- |
| 张三 | 张三出差1 | 张三出差2 | 张三出差3 | 张三出差4 | 张三出差5 |      |      |
| 李四 | 李四出差1 | 李四出差1 | 李四出差1 | 李四出差1 | 李四出差1 |      |      |
| 王五 | 王五出差1 | 王五出差1 | 王五出差2 | 王五出差2 | 王五出差3 |      |      |

对应的json如下

```json
{
    "code": "200",
    "msg": "成功",
    "leaders": [
        {
            "leaderId": 1,
            "leaderName": "张三",
            "datas": [
                {
                    "周一日程": "出差1"
                },
                {
                    "周二日程": "出差2"
                },
                {
                    "周三日程": "出差3"
                },
                {
                    "周四日程": "出差4"
                },
                {
                    "周五日程": "出差5"
                },
                {
                    "周六日程": "出差6"
                },
                {
                    "周日日程": "出差日"
                }
            ]
        },
        {
            "leaderId": 2,
            "leaderName": "李四",
            "datas": [
                "value",
                "value",
                "value",
                "value",
                "value"
            ]
        },
        {
            "leaderId": 3,
            "leaderName": "王五"
        }
    ]
}
```

## 统一返回结果

注意：需要使用lombok，如果不使用，则需要手动写set，get方法

```java
/**
 * 响应码和响应信息定义
 * @author  liuscoding
 */
public interface IResultCode {

    /**
     *  获取响应码
     * @return 响应码
     */
    Integer getCode();


    /**
     * 获取响应信息
     *
     * @return 响应信息
     */
    String getMsg();
}
```



```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ResultCode implements IResultCode {

    SUCCESS(20000, "操作成功"),

    ERROR(20001, "响应失败"),
    FILE_IS_EMPTY(20002, "请上传文件！！！"),

    SAVE_ERROR(20003, "添加失败"),

    UPDATE_ERROR(20004, "更新失败"),

    DATA_NO_EXIST(20005, "数据不存在"),

    UPLOAD_FILE_ERROR(20010, "文件上传失败"),

    FILE_EMPTY(20011, "文件为空"),

    DELETE_ERROR(20012, "删除失败"),

    VALID_CODE_SEND_FAIL(20013, "短信验证码发送失败"),

    LOGIN_ERROR(20014, "登录失败，用户名或密码错误！"),

    REGISTER_ERROR(20015, "注册失败"),

    PARAMS_ERROR(20020, "参数校验失败");


    private Integer code;

    private String msg;
  
```

```java
import com.liuscoding.commonutils.result.IResultCode;
import com.liuscoding.commonutils.result.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: ResultVo
 * @description: 统一返回结果的类
 * @author: lijie
 * @create: 2020-05-02 09:37
 */

@ApiModel("统一返回结果")
@Data
public class ResultVo {

    @ApiModelProperty("是否成功")
    private Boolean success;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回数据")
    private Map<String,Object> data = new HashMap<>();

    /**
     * 构造方法私有化
     */
    private ResultVo(){}

    /**
     * 成功的静态方法
     * @return ResultVo
     */
    public static ResultVo ok(){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        resultVo.setCode(ResultCode.SUCCESS.getCode());
        resultVo.setMessage(ResultCode.SUCCESS.getMsg());
        return resultVo;
    }

    /**
     * 失败的静态方法
     * @return ResultVo
     */
    public static ResultVo error(){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setCode(ResultCode.ERROR.getCode());
        resultVo.setMessage(ResultCode.ERROR.getMsg());
        return resultVo;
    }


    public ResultVo success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public ResultVo message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultVo code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultVo data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public ResultVo data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    public ResultVo codeAndMessage(IResultCode resultCode){
        this.setCode(resultCode.getCode());
        this.setMessage(resultCode.getMsg());
        return this;
    }
```

上述统一返回使用方法：

```java
1.发生异常的时候：
   public ResultVo error(Exception e) {
        log.error("异常信息：{}", e);
        return ResultVo.error().code(e.getCode()).message(e.getMsg());
    }
2.成功
   return ResultVo.ok();
3.失败
  return ResultVo.error();
4.带data数据体的返回
   List<ChapterVo> chapterVoList = chapterService.getChapterVideoByCourseId(courseId);
   return ResultVo.ok().data("allChapterVideo", chapterVoList);
4.1带data数据体的返回（不带key）
    Map<String, Object> userInfo = indexService.getUserInfo(username);
    return ResultVo.ok().data(userInfo);
5.带多个数据体的返回
   return ResultVo.ok().data("courseList",courseList).data("teacherList",teacherList);
6.自定义返回code和message的返回
   return ResultVo.ok().code(25000).message("支付中");
```



## 参考链接

[在线json编辑工具](http://json.la/online.html)