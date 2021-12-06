package com.herrhu.lottery.domain.strategy.repository;

import com.herrhu.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.herrhu.lottery.infrastructure.po.Award;

import java.util.List;

/**
 * @author herrhu
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     *
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
