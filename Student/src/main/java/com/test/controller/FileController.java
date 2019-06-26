package com.test.controller;
import com.test.entity.Papers;
import com.test.entity.Teachers;
import com.test.service.PaperService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller

public class FileController {
    @Autowired
    PaperService paperService;
    /**
     * 单个文件上传
     * @param request
     * @return
   */
    @RequestMapping(value="/upload2",produces="text/html;charset=utf-8")
    @ResponseBody
    private String upload2(@RequestParam("file")CommonsMultipartFile partFile,HttpServletRequest request,HttpSession session) {
        try {
            String path = request.getServletContext().getRealPath("/upload");
            String name = request.getParameter("name");
            String filename = partFile.getOriginalFilename();
            File file = new File(path+"/"+filename);
            InputStream inputStream = partFile.getInputStream();
            FileUtils.copyInputStreamToFile(inputStream, file);
            if(inputStream!=null){
                inputStream.close();
            }
            String point = request.getParameter("point");
            double difficulty =Double.parseDouble(request.getParameter("difficulty")) ;
            String content = filename;
            Teachers teachers=(Teachers)session.getAttribute("admin");
            String id=teachers.getTeacher_id();
            Papers papers=new Papers();
            papers.setTeacher_id(id);
            papers.setPaper_content(content);
            papers.setDifficulty(difficulty);
            papers.setPoint(point);
            papers.setPaper_date(new Date());
            paperService.addPaper(papers);
            return "文件上传成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败！";
        }
    }

    /**
     * 文件下载
     * @param request
     * @param response
     * @return
     * @throws IOException
     */

    @RequestMapping(value="/download")
    @ResponseBody
        public String down(HttpServletRequest request,HttpServletResponse response) throws IOException{
            //获取文件名称
            String name = request.getParameter("filename");

            //获取对应文件的路径
            String path = request.getServletContext().getRealPath("/upload") + "/" + name;

            //将文件读取到输入流
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));

            //设置文件转码
            name = URLEncoder.encode(name,"UTF-8");

            //解决中文显示乱码
            response.addHeader("Content-Disposition", "attachment;filename=" + name);

            //设置响应的类型
            response.setContentType("multipart/form-data");

            //将对应文件读取出来
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while((len = bis.read()) != -1){
                out.write(len);
                out.flush();
            }
            out.close();
            return null;
        }


    @RequestMapping(value="back",method=RequestMethod.POST)
    @ResponseBody
    /**
     * @param hostIP ip地址，可以是本机也可以是远程
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param savePath 备份的路径
     * @param fileName 备份的文件名
     * @param databaseName 需要备份的数据库的名称
     * @return
     */
    public static String  backup( String hostIP ,
            String userName,
            String password,
            String savePath,
            String fileName,
            String databaseName) {

        fileName +=".sql";
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }

        //拼接命令行的命令
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump").append(" --opt").append(" -h").append(hostIP);
        stringBuilder.append(" --user=").append(userName).append(" --password=").append(password)
                .append(" --lock-all-tables=true");
        stringBuilder.append(" --result-file=").append(savePath + fileName).append(" --default-character-set=utf8 ")
                .append(databaseName);
        try {
            //调用外部执行exe文件的javaAPI
            Process process = Runtime.getRuntime().exec(stringBuilder.toString());
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                return "true";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "false";
    }
    @RequestMapping(value="restore",method=RequestMethod.POST)
    @ResponseBody
    /**
     * @param filepath 数据库备份的脚本路径
     * @param ip IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public static String  recover( String ip ,
            String userName,
            String password,
            String filepath,
            String database) {


        String stmt1 = "mysqladmin -h "+ip+" -u "+userName+" -p"+password+" create "+database;

        String stmt2 = "mysql -h "+ip+" -u "+userName+" -p "+password+" "+database+" < " + filepath;

        String[] cmd = { "cmd", "/c", stmt2 };

        try {
            Runtime.getRuntime().exec(stmt1);
            Runtime.getRuntime().exec(cmd);
            System.out.println("数据已从 " + filepath + " 导入到数据库中");
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
        return "true";
    }
}