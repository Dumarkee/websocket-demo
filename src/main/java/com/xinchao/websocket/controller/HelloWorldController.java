package com.xinchao.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: 杜威
 * @Date: 2018/10/25 9:44
 * @Description:
 */
@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "/webSocketDemo";
    }
}
