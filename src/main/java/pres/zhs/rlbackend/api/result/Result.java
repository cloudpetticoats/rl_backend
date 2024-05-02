package pres.zhs.rlbackend.api.result;


/**
 * 向前端的返回结果
 */
public class Result {

    public static Re success(Object object) {
        return Re.builder()
                .code(REnum.SUCCESS.getCode())
                .msg(REnum.SUCCESS.getMsg())
                .data(object).build();
    }

    public static Re success(){
        return success(null);
    }

    public static Re Err(Integer code, String msg){
        return Re.builder()
                .code(REnum.UNKNOWN_ERROR.getCode())
                .msg(REnum.UNKNOWN_ERROR.getMsg())
                .data(null).build();
    }
}
