package com.herrhu.lottery.domain.strategy.repository;

import com.herrhu.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.herrhu.lottery.infrastructure.po.Award;
import com.herrhu.lottery.infrastructure.po.Strategy;

public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);
}
