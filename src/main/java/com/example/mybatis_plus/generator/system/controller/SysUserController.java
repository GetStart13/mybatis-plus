package com.example.mybatis_plus.generator.system.controller;


import com.example.mybatis_plus.generator.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fqq
 * @since 2021-11-29
 */
@Controller
@RequestMapping("/system/sysUser")
public class SysUserController {

    private ISysUserService service;

    @Autowired
    public void setService(ISysUserService service) {
        this.service = service;
    }

    //@GetMapping("/index")
    @RequestMapping("/index")
    public ModelAndView userList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", service.list());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

