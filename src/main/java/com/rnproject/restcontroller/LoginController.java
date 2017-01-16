package com.rnproject.restcontroller;

import com.rnproject.requestbean.User;
import com.rnproject.responsebean.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

/**
 * Created by mark on 17-1-16.
 */
@RestController
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier(value = "successResponse")
    private BaseResponse successResponse;

    @Autowired
    @Qualifier(value = "failedResponse")
    private BaseResponse failResponse;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse loginAction(@RequestBody User user) {
        logger.debug("login action {} {}", successResponse, failResponse);
        return failResponse;
    }

}
