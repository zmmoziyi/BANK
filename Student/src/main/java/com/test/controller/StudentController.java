package com.test.controller;

import com.test.entity.Student;
import com.test.service.StudentService;
import com.test.util.JsonDateValueProcessor;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张敏
 * @Title: StudentController
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/4/2518:38
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping(value="S_login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String student_id, String student_password , HttpSession session, HttpServletRequest request){
        HashMap student=studentService.login(student_id,student_password);

        if(student.get("isSuccess").equals("false")){
            return "false";
        }else{
            session.setAttribute("admin",student.get("admin"));

            return "true";
        }
    }
    @RequestMapping(value="changepasswordS",method = RequestMethod.POST)
    @ResponseBody
    public int  changepassword (String student_password ,String student_id,HttpSession session){

        return studentService.changeuser( student_password,student_id);
    }
    @RequestMapping(value="selectStudent",method = RequestMethod.POST)
    @ResponseBody
    public Student selectuser (HttpSession session){
        Student student=(Student)session.getAttribute("admin");
        String id=student.getStudent_id();
        System.out.println(id);
        return studentService.selectStudent(id);

    }
    @RequestMapping(value="selectAllStudent")
    @ResponseBody

    public JSON selectAll(Integer page ,Integer limit) {

        int before = limit*(page-1);
        int after=page*limit;
        List<Student> students=studentService.selectAll(before,after);
        int count=studentService.count();
        Map result=new HashMap();
        result.put("code",0);

        result.put("msg","");

        result.put("count",count);

        result.put("data",students);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject json = JSONObject.fromObject(result, jsonConfig);
        //实体转为JSON

        // System.out.println(json);
        return json;
    }
    @RequestMapping(value = "deleteStudent", method = RequestMethod.POST)
    @ResponseBody
    public int deleteStudent(String student_id, HttpSession session) {
        return studentService.deleteChoice(student_id);
    }
    @RequestMapping(value = "updateStudent", method = RequestMethod.POST)
    @ResponseBody
    public int updateStudent(Student student, HttpSession session) {
        return studentService.updateStudent(student);
    }
    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    @ResponseBody
    public int addStudent(Student student, HttpSession session) {
        return studentService.adduser(student);
    }
}
