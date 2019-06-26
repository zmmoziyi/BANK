package com.test.util.GA;

import com.test.service.serviceImpl.QuestionsServiceImpl;
import com.test.vo.Paper;
import com.test.vo.Population;
import com.test.vo.QuestionVo;
import com.test.vo.RuleVO;

import java.util.List;

/**
 * 遗传算法组卷实现类
 *
 * @author: lixiaolin
 * @CreateDate: 2016-4-29 下午03:57:55
 * @version: 1.0
 */
public class GA {
    /**
     * 变异概率
     */
    private static final double mutationRate = 0.01;
    /**
     * 精英主义
     */
    private static final boolean elitism = true;
    /**
     * 淘汰数组大小
     */
    private static final int tournamentSize = 5;

    // 进化种群
    public static Population evolvePopulation(Population pop, RuleVO rule) {
        Population newPopulation = new Population(pop.getLength());
        int elitismOffset;
        // 精英主义
        if (elitism) {
            elitismOffset = 1;
            // 保留上一代最优秀个体
            Paper fitness = pop.getFitness();
            fitness.setId(0);
            newPopulation.setPaper(0, fitness);
        }
        // 种群交叉操作，从当前的种群pop来创建下一代种群newPopulation
        for (int i = elitismOffset; i < newPopulation.getLength(); i++) {
            // 较优选择parent
            Paper parent1 = select(pop);//选择一张最优试卷
            Paper parent2 = select(pop);//选择一张最优试卷
            while (parent2.getId() == parent1.getId()) {
                parent2 = select(pop);
            }
            // 交叉
            Paper child = crossover(parent1, parent2, rule);
            child.setId(i);
            newPopulation.setPaper(i, child);
        }
        // 种群变异操作
        Paper tmpPaper;
        for (int i = elitismOffset; i < newPopulation.getLength(); i++) {
            tmpPaper = newPopulation.getPaper(i);
            mutate(tmpPaper);
            // 计算知识点覆盖率与适应度
        }
        return newPopulation;
    }

    /**
     * 交叉算子
     *
     * @param parent1
     * @param parent2
     * @return
     */
    public static Paper crossover(Paper parent1, Paper parent2, RuleVO rule) {
        Paper child = new Paper(parent1.getQuestionSize());
        int s1 = (int) (Math.random() * parent1.getQuestionSize());
        int s2 = (int) (Math.random() * parent1.getQuestionSize());

        // parent1的startPos endPos之间的序列，会被遗传到下一代
        int startPos = s1 < s2 ? s1 : s2;
        int endPos = s1 > s2 ? s1 : s2;
        for (int i = startPos; i < endPos; i++) {
            child.saveQuestion(i, parent1.getQuestion(i));
        }
        // 继承parent2中未被child继承的question
        for (int i = 0; i < startPos; i++) {

                child.saveQuestion(i, parent2.getQuestion(i));

        }

        return child;
    }


    /**
     * 突变算子 每个个体的每个基因都有可能突变
     *
     * @param paper
     */
    public static void mutate(Paper paper) {
        QuestionVo tmpQuestion;
        List<QuestionVo> list;
        int index;
        for (int i = 0; i < paper.getQuestionSize(); i++) {
            if (Math.random() < mutationRate) {
                // 进行突变，第i道
                tmpQuestion = paper.getQuestion(i);
                // 从题库中获取和变异的题目类型一样分数相同的题目（不包含变异题目）
                QuestionsServiceImpl questionsService =new QuestionsServiceImpl();
                list = questionsService.getQuestionWithoutId(tmpQuestion.getType() ,tmpQuestion.getScore(),tmpQuestion.getId());
                if (list.size() > 0) {
                    // 随机获取一道
                    index = (int) (Math.random() * list.size());
                    paper.saveQuestion(i, list.get(index));
                }
            }
        }
    }

    /**
     * 选择算子
     *
     * @param population
     */
    private static Paper select(Population population) {

        Population pop = new Population(20);
        for (int i = 0; i < 20; i++) {
            pop.setPaper(i, population.getPaper(i));
        }
        return pop.getFitness();
    }
}
