package com.test.service;

import com.test.entity.Papers;
import com.test.vo.PaperVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张敏
 * @Title: PaperService
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/4/3017:57
 */
@Service
public interface PaperService {
    /**
     * 加载所有试卷
     * @return
     */
    public List<PaperVo> selectAllpaper(int before, int after);

    /**
     * 计算试卷总数
     * @return
     */

    public int count();


    /**
     * 删除试卷
     * @param paper_id
     * @return
     */

    public int deletePaper(int paper_id);
    /**
     * 上传试卷
     * @param papers
     * @return
     */

    public int addPaper(Papers papers);
}
