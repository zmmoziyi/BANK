package com.test.controller;

import com.test.entity.Student;
import com.test.entity.Teachers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 张敏
 * @Title: GetSession
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/4/2315:14
 */
@Controller
public class GetSession {
    @RequestMapping(value = "getSession", method = RequestMethod.POST)
    @ResponseBody
    public Teachers getSession(HttpSession session) {

        Teachers teachers=(Teachers)session.getAttribute("admin");
        return teachers;
    }
    /**
     * 后台退出登录
     * @return
     */
    @RequestMapping(value = "adminLogout",method = RequestMethod.POST)
    @ResponseBody
    public String adminLogout(HttpSession session){
        try{
            session.removeAttribute("admin");
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }
}
