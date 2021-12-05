package com.herrhu.lottery.domain.strategy.model.aggregates;

import com.herrhu.lottery.infrastructure.po.Strategy;
import com.herrhu.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/5 14:46
 */
public class StrategyRich {

    private Long strategyId;

    private Strategy strategy;

    private List<StrategyDetail> strategyDetailList;

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

    public StrategyRich() {
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetail> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetail> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}
