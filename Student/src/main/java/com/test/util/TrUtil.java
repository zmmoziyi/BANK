package com.test.util;

import com.test.vo.RuleVO;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author 张敏
 * @Title: TrUtil
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/1211:04
 */
public class TrUtil {
    public static int[] GetType(RuleVO ruleVO){//获取选中的试题类型
        int [] type =new int[5];

        if(ruleVO.getChoiceNum()>0){//选择题被选中
            type[0]=1;
        }
        if(ruleVO.getCompletionsNum()>0){//填空题被选中
            type[1]=2;
        }
        if(ruleVO.getJudgmentsNum()>0){//选择题
            type[2]=3;
        }
        if(ruleVO.getDefinitionsNum()>0){//名词解释
            type[3]=4;
        }
        if(ruleVO.getShortAnswerNum()>0){//简答
            type[4]=5;
        }

        if(ruleVO.getDiscussionsNum()>0){//论述
            type[5]=6;
        }


        return  type;
    }
    public static List getRandomList(List paramList,int count){
        if(paramList.size()<count){
            return paramList;
        }
        Random random=new Random();
        List<Integer> tempList=new ArrayList<Integer>();
        List<Object> newList=new ArrayList<Object>();
        int temp=0;
        for(int i=0;i<count;i++){
            temp=random.nextInt(paramList.size());//将产生的随机数作为被抽list的索引
            if(!tempList.contains(temp)){//去重
                tempList.add(temp);
                newList.add(paramList.get(temp));
            }
            else{
                i--;
            }
        }
        return newList;
    }


}
