package com.gathe.auth.controller;

import com.gathe.auth.domain.oauth.client.RegistrantClient;
import com.gathe.auth.service.OAuthClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class OAuthClientAccountController {

    private static final String REGISTER_FORM_MODEL = "client";

    private final OAuthClientDetailsService service;

    public OAuthClientAccountController(final OAuthClientDetailsService service) {
        this.service = service;
    }

    @RequestMapping(value = "/web/admin/client/account/login", method = GET)
    public String toLoginPage() {
        return "/oauth/client/login.html";
    }

    @RequestMapping(value = "/web/admin/client/account/register", method = GET)
    public String toRegisterPage(@ModelAttribute("client") RegistrantClient client, Model model) {

        Map md = model.asMap();
        for (Object modelKey : md.keySet()) {
//            Object modelValue = md.get(modelKey);
//            BindingResult binding = null;
//            if (modelValue instanceof BindingResult) {
//                binding = (BindingResult) modelValue;
//                for (ObjectError err: binding.getAllErrors()) {
//                    String objName = err.getObjectName();
//                }
//            }
//            else
//            if (REGISTER_FORM_MODEL.equals(modelKey)) {
//                redirectedFromError = true;
//            }
        }

//        if (!redirectedFromError) {
//            registrantClient = new RegistrantClient();
//            model.addAttribute(REGISTER_FORM_MODEL, registrantClient);
//        }

        return "/oauth/client/register.html";
    }

    @PostMapping("/web/admin/client/account/register")
    public String doRegister(
                                @ModelAttribute("client") @Valid RegistrantClient client,
                                BindingResult binding,
                                Model model)
                            {

        if (binding.hasErrors()) {
            for (ObjectError error: binding.getAllErrors()) {
                String name = error.getObjectName();
            }
            return "/oauth/client/register.html";
        }

        if (client.isClientSecretConfirmed()) {

            boolean registered = service.registerAccount(client);

            if (registered) return "redirect:/web/admin/client/home";
        }

        return "redirect:/web/admin/client/account/register?error";
    }
}
