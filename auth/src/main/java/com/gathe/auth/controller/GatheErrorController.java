package com.gathe.auth.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class GatheErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error", method = GET)
    public String handleError(HttpServletRequest request) {

        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status == null) {
            return "redirect:/internal-error";
        }
        else {
            switch (status) {
                case 404: {
                    return "redirect:/page-not-found";
                }
                case 500: {
                    return "redirect:/internal-error";
                }
                default: {
                    return "error";
                }
            }
        }


    }

    @RequestMapping(value = "/page-not-found", method = GET)
    public String toPageNotFound() {
        return "/main/page-not-found";
    }

    @RequestMapping(value = "/internal-error", method = GET)
    public String toInternalError() {
        return "/main/internal-error";
    }


}
