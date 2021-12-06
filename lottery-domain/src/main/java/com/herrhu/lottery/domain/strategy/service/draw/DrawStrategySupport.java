package com.herrhu.lottery.domain.strategy.service.draw;

import com.herrhu.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.herrhu.lottery.domain.strategy.repository.IStrategyRepository;
import com.herrhu.lottery.infrastructure.po.Award;
import com.herrhu.lottery.infrastructure.po.Strategy;

import javax.annotation.Resource;

/**
 * @description: 抽奖策略数据支持，一些通用的数据服务
 * @author: HerrHu
 * @time: 2021/12/5 22:09
 */
public class DrawStrategySupport extends DrawConfig{
    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     * @param strategyId
     * @return
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     * @param awardId
     * @return
     */
    protected Award queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }
}
