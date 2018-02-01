package com.csrf.demo1;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {

    @RequestMapping(value = "/xss")
    public String indexXSS() {
        return "xss";
    }

    @RequestMapping(value = "/csrf")
    public String indexCSRF(Model model) {
        String password= RandomStringUtils.randomAlphanumeric(6);
        model.addAttribute("password",password);
        String modifyUrl="http://localhost:8080/verify?newPassword1="+password
                +"&newPassword2="+password;
        String transferUrl="http://localhost:8080/transfer?username=hacker&money=50";
        model.addAttribute("modifyUrl",modifyUrl);
        model.addAttribute("transferUrl",transferUrl);
        return "csrf";
    }

//    @RequestMapping(value = "/test")
//    public void testCSRF(@ModelAttribute(value="url") Url url) {
//        String webUrl=url.getWebUrl();
//        System.out.println("webUrl-1:"+webUrl);
//
//    }
}
