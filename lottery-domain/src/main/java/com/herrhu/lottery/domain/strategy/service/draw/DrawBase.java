package com.herrhu.lottery.domain.strategy.service.draw;

import com.herrhu.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.herrhu.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.herrhu.lottery.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/5 18:18
 */
public class DrawBase extends DrawConfig{
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        //策略1需要初始化，其他不需要
        if (1 != strategyMode) {
            return;
        }
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) {
            return;
        }

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}
