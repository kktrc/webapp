package me.pzzls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C) 2017 mosl, Inc.
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 *
 * @author <a href="mailto:moshenglei@icloud.com">mosl</a>
 * @since 2017/2/21 下午7:44
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    @ResponseBody
    public String register() {
        return "register";
    }
}
