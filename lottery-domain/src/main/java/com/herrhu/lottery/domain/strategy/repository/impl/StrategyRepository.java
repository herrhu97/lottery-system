package com.herrhu.lottery.domain.strategy.repository.impl;

import com.herrhu.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.herrhu.lottery.domain.strategy.repository.IStrategyRepository;
import com.herrhu.lottery.infrastructure.dao.IAwardDao;
import com.herrhu.lottery.infrastructure.dao.IStrategyDao;
import com.herrhu.lottery.infrastructure.dao.IStrategyDetailDao;
import com.herrhu.lottery.infrastructure.po.Award;
import com.herrhu.lottery.infrastructure.po.Strategy;
import com.herrhu.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/5 14:48
 */
@Component
public class StrategyRepository  implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetails);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
