package com.test.controller;

import com.test.entity.Choices;

import com.test.entity.Teachers;
import com.test.service.ChoiceService;
import com.test.service.serviceImpl.ChoicesServicesImpl;
import com.test.util.JsonDateValueProcessor;
import com.test.vo.ChoiceVo;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张敏
 * @Title: ChoicesController
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/2/1514:38
 */
@Controller
public class
ChoicesController {
    @Autowired
    ChoiceService choiceService;
    @RequestMapping(value = "queryChoiceByIdByDifficulty", method = RequestMethod.POST)
    @ResponseBody
    public List<Choices> selectByDifficulty(Double choice_difficulty, HttpSession session) {
        return choiceService.crateChoice(choice_difficulty);
    }

    @RequestMapping(value = "queryChoiceById", method = RequestMethod.POST)
    @ResponseBody
    public Choices selectByPrimaryKey(int choice_id, HttpSession session) {
        return choiceService.selectByPrimaryKey(choice_id);
    }


    @RequestMapping(value = "selectAllChoice")
    @ResponseBody
    public JSON selectAllChoice(HttpServletRequest request, HttpServletResponse response, int page , int limit) {
        String point=request.getParameter("point");
        int before = limit*(page-1);
        int after=page*limit;
        List<ChoiceVo> choices=choiceService.selectAllChoice(point,before,after);
        int count=choiceService.count();
        Map result=new HashMap();
        result.put("code",0);

        result.put("msg","");

        result.put("count",count);

        result.put("data",choices);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = JSONObject.fromObject(result, jsonConfig);
        //实体转为JSON

       // System.out.println(json);
        return json;
    }
    @RequestMapping(value = "addChoice", method = RequestMethod.POST)
    @ResponseBody
    public int addChoice(Choices choices, HttpSession session) {
        Teachers teachers=(Teachers)session.getAttribute("admin");
        String id=teachers.getTeacher_id();
        choices.setTeacher_id(id);
        choices.setChoice_time(new Date());
        return choiceService.addChoice(choices);
    }

    @RequestMapping(value = "deleteChoice", method = RequestMethod.POST)
    @ResponseBody
    public int deleteChoice(int choice_id, HttpSession session) {
        return choiceService.deleteChoice(choice_id);
    }
    @RequestMapping(value = "updateChoice", method = RequestMethod.POST)
    @ResponseBody
    public int updateChoice(Choices choices, HttpSession session) {
        return choiceService.updateChoice(choices);
    }
    @RequestMapping(value = "ChoicePaper", method = RequestMethod.POST)
    @ResponseBody
    public List<Choices> paper(String point, HttpSession session) {
        return choiceService.paper(point);
    }
}