package com.test.controller;

import com.test.entity.Completions;
import com.test.entity.Discussions;
import com.test.entity.Teachers;
import com.test.service.CompletionService;
import com.test.service.DiscussionService;
import com.test.util.JsonDateValueProcessor;
import com.test.vo.CompletionVo;
import com.test.vo.DiscussionVo;
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
public class DiscussionController {
    @Autowired
    DiscussionService discussionService;
    @RequestMapping(value = "addDiscussion", method = RequestMethod.POST)
    @ResponseBody
    public int add(Discussions discussions , HttpSession session) {
        Teachers teachers=(Teachers)session.getAttribute("admin");
        String id=teachers.getTeacher_id();
        discussions.setTeacher_id(id);
        discussions.setDiscussion_time(new Date());
        return discussionService.addDiscussions(discussions);
    }
    @RequestMapping(value = "selectAllDiscussion")
    @ResponseBody
    public JSON selectAllChoice(HttpServletRequest request, HttpServletResponse response, int page , int limit) {
        String point=request.getParameter("point");
        int before = limit*(page-1);
        int after=page*limit;
        List<DiscussionVo> completions=discussionService.selectAll(point,before,after);
        int count=discussionService.count();
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
    @RequestMapping(value = "updateDiscussion", method = RequestMethod.POST)
    @ResponseBody
    public int updateCompletion(Discussions discussions, HttpSession session) {
        return discussionService.updateDiscussions(discussions);
    }
    @RequestMapping(value = "deleteDiscussion", method = RequestMethod.POST)
    @ResponseBody
    public int deleteCompletion(int discussion_id, HttpSession session) {
        return discussionService.deleteDiscussion(discussion_id);
    }
    @RequestMapping(value = "DiscussionPaper", method = RequestMethod.POST)
    @ResponseBody
    public List<Discussions> paper(String point, HttpSession session) {
        return discussionService.paper(point);
    }
}