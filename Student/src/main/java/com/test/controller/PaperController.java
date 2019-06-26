package com.test.controller;


//import com.test.util.GA.GA;
import com.test.entity.Papers;
import com.test.service.PaperService;
import com.test.service.QuestionsService;
import com.test.util.GA.GA;
import com.test.util.JsonDateValueProcessor;
import com.test.util.TrUtil;
import com.test.vo.Paper;
import com.test.vo.PaperVo;
import com.test.vo.Population;
import com.test.vo.RuleVO;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.hibernate.validator.internal.xml.GetterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张敏
 * @Title: PaperController
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/717:25
 */
@Controller
public class PaperController {
    @Autowired
    PaperService paperService;
    @RequestMapping(value = "getPaper", method = RequestMethod.POST)
    @ResponseBody
    public Paper getPaper(RuleVO ruleVO, HttpSession session) {
        Paper resultPaper = null;
        // 迭代计数器
        int count = 0;
        int runCount = 100;
        // 适应度期望值
        double expand = 0.02;
        if (ruleVO != null) {
            // 初始化种群
            Population population = new Population(20, true, ruleVO);
            while (count < runCount && population.getFitness().getAdaptationDegree() > expand) {
                count++;
                population = GA.evolvePopulation(population, ruleVO);

            }
            resultPaper = population.getFitness();
        }

        return resultPaper;
    }

    @RequestMapping(value = "selectAllPaper")
    @ResponseBody
    public JSON selectAllChoice(int page , int limit) {

        int before = limit*(page-1);
        int after=page*limit;
        List<PaperVo> papers=paperService.selectAllpaper(before,after);
        int count=paperService.count();
        Map result=new HashMap();
        result.put("code",0);

        result.put("msg","");

        result.put("count",count);

        result.put("data",papers);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = JSONObject.fromObject(result, jsonConfig);
        //实体转为JSON

        // System.out.println(json);
        return json;
    }

    @RequestMapping(value = "deletePaper", method = RequestMethod.POST)
    @ResponseBody
    public int deletepaper(int paper_id, HttpSession session) {
        return paperService.deletePaper(paper_id);
    }
    @RequestMapping(value = "creatPaper", method = RequestMethod.POST)
    @ResponseBody
    public int paper(int paper_id, HttpSession session) {
        return paperService.deletePaper(paper_id);
    }

}
