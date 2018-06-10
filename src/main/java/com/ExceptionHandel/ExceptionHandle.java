package com.ExceptionHandel;

import com.ResponsResult.ResponsVo;
import com.exception.ParamValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xly on 2018/4/14.
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final String RESULT_CODE = "10001";
    private static final String  INVALID_PARAM= "invalid param";

    @ResponseBody
    @ExceptionHandler({ParamValidException.class})
    public ResponsVo handelParamException(){
        ResponsVo responsVo = new ResponsVo();
        responsVo.setResultCode(RESULT_CODE);
        responsVo.setResultMsg(INVALID_PARAM);
        System.out.println(responsVo);
        return responsVo;
    }
}
