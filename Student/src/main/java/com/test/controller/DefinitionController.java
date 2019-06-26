package com.test.controller;

import com.test.entity.Completions;
import com.test.entity.Definitions;
import com.test.entity.Teachers;
import com.test.service.CompletionService;
import com.test.service.DefinitionService;
import com.test.util.JsonDateValueProcessor;
import com.test.vo.CompletionVo;
import com.test.vo.DefinitionVo;
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
public class DefinitionController {
    @Autowired
    DefinitionService definitionService;

    @RequestMapping(value = "addDefinition", method = RequestMethod.POST)
    @ResponseBody
    public int add(Definitions definitions, HttpSession session) {
        Teachers teachers=(Teachers)session.getAttribute("admin");
        String id=teachers.getTeacher_id();
        definitions.setTeacher_id(id);
        definitions.setChoice_time(new Date());
        return definitionService.addDefinition(definitions);
    }
    @RequestMapping(value = "selectAllDefinition")
    @ResponseBody
    public JSON selectAllChoice(HttpServletRequest request, HttpServletResponse response, int page , int limit) {
        String point=request.getParameter("point");
        int before = limit*(page-1);
        int after=page*limit;
        List<DefinitionVo> completions=definitionService.selectAll(point,before,after);
        int count=definitionService.count();
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
    @RequestMapping(value = "updateDefinition", method = RequestMethod.POST)
    @ResponseBody
    public int updateDefinition(Definitions definitions, HttpSession session) {
        return definitionService.updateDefinition(definitions);
    }
    @RequestMapping(value = "deleteDefinition", method = RequestMethod.POST)
    @ResponseBody
    public int deleteDefinition(int definitions_id, HttpSession session) {
        return definitionService.deleteDefinition(definitions_id);
    }
    @RequestMapping(value = "DefinitionPaper", method = RequestMethod.POST)
    @ResponseBody
    public List<Definitions> paper(String point, HttpSession session) {
        return definitionService.paper(point);
    }
}