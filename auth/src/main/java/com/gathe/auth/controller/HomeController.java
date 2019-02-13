package com.gathe.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @RequestMapping(value = "/admin/web/client", method = GET)
    public String redirectToHome() {
        return "redirect:/admin/web/client/home";
    }

    @RequestMapping(value = "/admin/web/client/home", method = GET)
    public String toHome() {
        return "/main/home";
    }


}
