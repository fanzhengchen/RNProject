package com.rnproject;

import com.rnproject.responsebean.BaseResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * Created by mark on 17-1-16.
 */
@org.springframework.stereotype.Service
public class Service {

    @Bean(name = "successResponse")
    public BaseResponse provideSuccessResponse() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMessage("success");
        return baseResponse;
    }

    @Bean(name = "failedResponse")
    public BaseResponse provideFailResponse() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(-1);
        baseResponse.setMessage("fail");
        return baseResponse;
    }


}
