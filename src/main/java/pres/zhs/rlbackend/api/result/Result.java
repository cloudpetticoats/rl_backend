package pres.zhs.rlbackend.api.result;


/**
 * 向前端的返回结果
 */
public class Result {

    public static R success(Object object) {
        return R.builder()
                .code(REnum.SUCCESS.getCode())
                .msg(REnum.SUCCESS.getMsg())
                .data(object).build();
    }

    public static R success(){
        return success(null);
    }

    public static R Err(Integer code,String msg){
        return R.builder()
                .code(REnum.UNKNOWN_ERROR.getCode())
                .msg(REnum.UNKNOWN_ERROR.getMsg())
                .data(null).build();
    }
}
