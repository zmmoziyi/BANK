package com.test.controller;

import com.test.entity.Teachers;
import com.test.service.TeacherService;
import com.test.util.JsonDateValueProcessor;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张敏
 * @Title: TeacherController
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/2/1310:41
 */
@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @RequestMapping(value="T_login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String teacher_id,String teacher_password , HttpSession session,HttpServletRequest request){
        HashMap teachers = teacherService.login(teacher_id,teacher_password);
        if(teachers.get("isSuccess").equals("false")){
            return "false";
        }else{
          session.setAttribute("admin",teachers.get("admin"));
          Teachers t = (Teachers) session.getAttribute("admin");
            System.out.println(t.getTeacher_name());
            return "true";
        }
    }
    @RequestMapping(value="deleteuser",method = RequestMethod.POST)
    @ResponseBody
    public int  deletesuer  (String teacher_id , HttpSession session){

        return teacherService.deleteuser(teacher_id);

    }
    @RequestMapping(value="selectuser",method = RequestMethod.POST)
    @ResponseBody
    public Teachers selectuser ( HttpSession session){
        Teachers teachers=(Teachers)session.getAttribute("admin");
        String id=teachers.getTeacher_id();
        System.out.println(id);
        return teacherService.selectTeacher(id);

    }
    @RequestMapping(value="selectAllTeacher")
    @ResponseBody

        public JSON selectAll(int page , int limit) {

            int before = limit*(page-1);
            int after=page*limit;
            List<Teachers> teachers=teacherService.selectAll(before,after);
            int count=teacherService.count();
            Map result=new HashMap();
            result.put("code",0);

            result.put("msg","");

            result.put("count",count);

            result.put("data",teachers);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONObject json = JSONObject.fromObject(result, jsonConfig);
            //实体转为JSON

            // System.out.println(json);
            return json;
        }


    @RequestMapping(value="addTeacher",method = RequestMethod.POST)
    @ResponseBody
    public int  addsuer (Teachers teachers,HttpSession session){

        return teacherService.adduser(teachers);

    }
    @RequestMapping(value="createpaper",method = RequestMethod.POST)
    @ResponseBody
    public String createpaper  (String teacher_id,String teacher_password , HttpSession session){
        HashMap teachers = teacherService.login(teacher_id,teacher_password);
        session.setAttribute("teachers",teachers);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(teachers);
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
    @RequestMapping(value="changepassword",method = RequestMethod.POST)
    @ResponseBody
    public int  changepassword (String teacher_password,String teacher_id ,HttpSession session){

        return teacherService.changeuser( teacher_password,teacher_id);
    }
    @RequestMapping(value = "deleteTeacher", method = RequestMethod.POST)
    @ResponseBody
    public int deleteTeacher(String teacher_id, HttpSession session) {
        return teacherService.deleteteacher(teacher_id);
    }
    @RequestMapping(value = "updateTeacher", method = RequestMethod.POST)
    @ResponseBody
    public int updateTeacher(Teachers teachers, HttpSession session) {
        return teacherService.updateTeacher(teachers);
    }
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
