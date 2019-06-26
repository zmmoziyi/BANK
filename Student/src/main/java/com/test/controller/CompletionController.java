package com.test.controller;

import com.test.entity.Choices;
import com.test.entity.Completions;
import com.test.entity.Teachers;
import com.test.service.ChoiceService;
import com.test.service.CompletionService;
import com.test.util.JsonDateValueProcessor;
import com.test.vo.ChoiceVo;
import com.test.vo.CompletionVo;
import net.sf.json.JSON;
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
public class CompletionController {
    @Autowired
    CompletionService completionService;
    @RequestMapping(value = "addCompletion", method = RequestMethod.POST)
    @ResponseBody
    public int add(Completions completions, HttpSession session) {
        Teachers teachers=(Teachers)session.getAttribute("admin");
        String id=teachers.getTeacher_id();
        completions.setTeacher_id(id);
        completions.setChoice_time(new Date());
        return completionService.addCompletion(completions);
    }
    @RequestMapping(value = "selectAllCompletion")
    @ResponseBody
    public JSON selectAllChoice(HttpServletRequest request, HttpServletResponse response, int page , int limit) {
        String point=request.getParameter("point");
        int before = limit*(page-1);
        int after=page*limit;
        List<CompletionVo> completions=completionService.selectAllChoice(point,before,after);
        int count=completionService.count();
        Map result=new HashMap();
        result.put("code",0);

        result.put("msg","");

        result.put("count",count);

        result.put("data",completions);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = JSONObject.fromObject(result, jsonConfig);
        //实体转为JSON

       // System.out.println(json);
        return json;
    }
    @RequestMapping(value = "updateCompletion", method = RequestMethod.POST)
    @ResponseBody
    public int updateCompletion(Completions completions, HttpSession session) {
        return completionService.updateCompletion(completions);
    }
    @RequestMapping(value = "deleteCompletion", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCompletion(int completion_id, HttpSession session) {
        return completionService.deleteCompletion(completion_id);
    }

    @RequestMapping(value = "CompletionPaper", method = RequestMethod.POST)
    @ResponseBody
    public List<Completions> paper(String point, HttpSession session) {
        return completionService.paper(point);
    }

}