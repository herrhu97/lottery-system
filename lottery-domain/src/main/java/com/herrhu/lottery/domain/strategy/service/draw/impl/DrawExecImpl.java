package com.herrhu.lottery.domain.strategy.service.draw.impl;

import com.herrhu.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.herrhu.lottery.domain.strategy.model.req.DrawReq;
import com.herrhu.lottery.domain.strategy.model.res.DrawResult;
import com.herrhu.lottery.domain.strategy.repository.IStrategyRepository;
import com.herrhu.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.herrhu.lottery.domain.strategy.service.draw.DrawBase;
import com.herrhu.lottery.domain.strategy.service.draw.IDrawExec;
import com.herrhu.lottery.infrastructure.po.Award;
import com.herrhu.lottery.infrastructure.po.Strategy;
import com.herrhu.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/5 18:27
 */
public class DrawExecImpl extends DrawBase implements IDrawExec {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        logger.info("执行策略抽奖开始，strategyId：{}", req.getStrategyId());

        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        Award award = strategyRepository.queryAwardInfo(awardId);

        logger.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", req.getuId(), awardId, award.getAwardName());

        return new DrawResult(req.getuId(), req.getStrategyId(), awardId, award.getAwardName());
    }
}
