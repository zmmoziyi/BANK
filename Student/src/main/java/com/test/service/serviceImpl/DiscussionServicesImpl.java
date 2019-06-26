package com.test.service.serviceImpl;

import com.test.dao.DefinitionsMapper;
import com.test.dao.DiscussionsMapper;
import com.test.entity.Definitions;
import com.test.entity.Discussions;
import com.test.service.DefinitionService;
import com.test.service.DiscussionService;
import com.test.vo.DefinitionVo;
import com.test.vo.DiscussionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张敏
 * @Title: ChoicesServicesImpl
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/2/1512:00
 */
@Service
public class DiscussionServicesImpl implements DiscussionService {
    @Autowired
    DiscussionsMapper discussionsMapper;
    //ChoiceVo choiceVo;


    @Override
    public List<Discussions> crateChoice(Double discussion_difficulty) {
        return null;
    }

    @Override
    public Discussions selectByPrimaryKey(int discussion_id) {
        return discussionsMapper.selectByPrimaryKey(discussion_id);
    }

    @Override
    public List<Discussions> paper(String point) {
        return discussionsMapper.selectByPoint(point);
    }

    @Override
    public int addDiscussions(Discussions discussions) {
        return discussionsMapper.insertSelective(discussions);
    }

    @Override
    public int updateDiscussions(Discussions discussions) {
        return discussionsMapper.updateByPrimaryKeySelective(discussions);
    }

    @Override
    public int deleteDiscussion(int discussion_id) {
        return discussionsMapper.deleteByPrimaryKey(discussion_id);
    }

    @Override
    public List<DiscussionVo> selectAll(String point,int before, int after) {
        List<Discussions> discussions=discussionsMapper.selectAll(point,before,after);

        List <DiscussionVo> list=new ArrayList<DiscussionVo>();
        for(int i = 0;i <discussions .size();i++){
            DiscussionVo discussionVo=new DiscussionVo();
            discussionVo.setDiscussion_id(discussions.get(i).getDiscussion_id());
            discussionVo.setDiscussion_content(discussions.get(i).getDiscussion_content());
            discussionVo.setDiscussion_answer(discussions.get(i).getDiscussion_answer());
            System.out.println(discussions.get(i).getDiscussion_answer());
            discussionVo.setDiscussion_difficulty(discussions.get(i).getDiscussion_difficulty());
            discussionVo.setPoint(discussions.get(i).getPoint());
            discussionVo.setChoice_time(discussions.get(i).getDiscussion_time());
            discussionVo.setTeacher_name(discussions.get(i).getTeachers().getTeacher_name());
            list.add(discussionVo);
        }
        return list;
    }

    @Override
    public int count() {
        return discussionsMapper.count();
    }
}
