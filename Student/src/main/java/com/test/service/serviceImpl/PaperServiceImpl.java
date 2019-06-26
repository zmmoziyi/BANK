package com.test.service.serviceImpl;

import com.test.dao.PapersMapper;
import com.test.entity.Papers;
import com.test.service.PaperService;
import com.test.vo.PaperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张敏
 * @Title: PaperServiceImpl
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/4/3018:01
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PapersMapper papersMapper;
    @Override
    public List<PaperVo> selectAllpaper(int before, int after) {

        List<Papers> papers=papersMapper.selectAllpaper(before,after);
        System.out.println(papersMapper.selectAllpaper(before,after));
        List <PaperVo> list=new ArrayList<PaperVo>();
        for(int i = 0;i <papers.size();i++){
            PaperVo paperVo=new PaperVo();
            paperVo.setPaper_id(papers.get(i).getPaper_id());
            paperVo.setPaper_date(papers.get(i).getPaper_date());
            paperVo.setTeacher_name(papers.get(i).getTeachers().getTeacher_name());
            paperVo.setDifficulty(papers.get(i).getDifficulty());
            paperVo.setPoint(papers.get(i).getPoint());
            paperVo.setPaper_content(papers.get(i).getPaper_content());

            list.add(paperVo);
        }
        return list;
    }

    @Override
    public int count() {
        return papersMapper.count();
    }

    @Override
    public int deletePaper(int paper_id) {
        return papersMapper.deleteByPrimaryKey( paper_id);
    }

    @Override
    public int addPaper(Papers papers) {
        return papersMapper.insertSelective(papers);
    }
}
