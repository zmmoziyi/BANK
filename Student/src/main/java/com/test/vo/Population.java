package com.test.vo;

import com.test.service.QuestionsService;
import com.test.service.serviceImpl.QuestionsServiceImpl;

import com.test.util.TrUtil;

import javax.validation.constraints.Max;


/**
 * 种群，即多套试卷
 *
 * @author: xlli
 * @CreateDate: 2016-4-29 下午01:29:02
 * @version: 1.0
 */
public class Population {
    // private Log log = LogFactory.getLog(Population.class);
    /**
     * 试卷集合
     */
    private Paper[] papers;

    /**
     * 初始种群
     *
     * @param populationSize 种群规模
     * @param initFlag       初始化标志 true-初始化
     * @param rule           规则bean
     */
    public Population(int populationSize, boolean initFlag, RuleVO rule) {
        papers = new Paper[populationSize];
        //获得选中的试题类型
        int[] type = TrUtil.GetType(rule);
        //获取试题

        QuestionsService questionsService = new QuestionsServiceImpl();
        if (initFlag) {
            Paper paper;
            for (int i = 0; i < populationSize; i++) {
                paper = new Paper();
                paper.setId(i + 1);
                while (paper.getTotalScore() != rule.getTotalMark()) {
                    paper.getQuestionList().clear();
                    paper.setQuestionList(questionsService.getQuestionArray(rule));
                    //计算试卷总分
                    //计算试卷难度系数
                    // 计算试卷适应度

                }
                papers[i] = paper;
            }
        }

    }

            /**
             * 获取种群中最优秀个体
             *
             * @return
             */

            public Paper getFitness () {
                Paper paper = papers[0];
                for(int i = 1; i < papers.length; i++){

                    if (paper.getAdaptationDegree() < papers[i].getAdaptationDegree()) {
                        paper = papers[i];
                    }
                }
                return paper;
            }

          public Population(int populationSize) {
        papers = new Paper[populationSize];
    }
            /**
             * 获取种群中某个个体
             *
             * @param index
             * @return
             */
            public Paper getPaper ( int index){
                return papers[index];
            }

            /**
             * 设置种群中某个个体
             *
             * @param index
             * @param paper
             */
            public void setPaper ( int index, Paper paper){
                papers[index] = paper;
            }

            /**
             * 返回种群规模
             *
             * @return
             */
            public int getLength () {
                return papers.length;
            }

        }


