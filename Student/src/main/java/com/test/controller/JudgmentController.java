package com.test.controller;

import com.test.entity.Completions;
import com.test.entity.Judgments;
import com.test.entity.Teachers;
import com.test.service.CompletionService;
import com.test.service.JudgmentService;
import com.test.util.JsonDateValueProcessor;
import com.test.vo.CompletionVo;
import com.test.vo.JudgmentVo;
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
public class JudgmentController {
    @Autowired
    JudgmentService judgmentService;
    @RequestMapping(value = "addJudgment", method = RequestMethod.POST)
    @ResponseBody
    public int add(Judgments judgments, HttpSession session) {
        Teachers teachers=(Teachers)session.getAttribute("admin");
        System.out.println(judgments.getJudgment_content());
        String id=teachers.getTeacher_id();
        judgments.setTeacher_id(id);
        judgments.setChoice_time(new Date());
        return judgmentService.addJudgments(judgments);
    }
    @RequestMapping(value = "selectAllJudgment")
    @ResponseBody
    public JSON selectAllChoice(HttpServletRequest request, HttpServletResponse response, int page , int limit) {
        String point=request.getParameter("point");
        int before = limit*(page-1);
        int after=page*limit;
        List<JudgmentVo> completions=judgmentService.selectAll(point,before,after);
        int count=judgmentService.count();
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
    @RequestMapping(value = "updateJudgment", method = RequestMethod.POST)
    @ResponseBody
    public int updateCompletion(Judgments judgments, HttpSession session) {
        return judgmentService.updateJudgments(judgments);
    }
    @RequestMapping(value = "deleteJudgment", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCompletion(int judgment_id, HttpSession session) {
        return judgmentService.deleteJudgments(judgment_id);
    }
    @RequestMapping(value = "JudgmentPaper", method = RequestMethod.POST)
    @ResponseBody
    public List<Judgments> paper(String point, HttpSession session) {
        return judgmentService.paper(point);
    }
}