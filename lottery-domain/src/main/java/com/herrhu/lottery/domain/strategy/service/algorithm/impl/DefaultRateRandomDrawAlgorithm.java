package com.herrhu.lottery.domain.strategy.service.algorithm.impl;

import com.herrhu.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.herrhu.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 必中策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 * @author: HerrHu
 * @time: 2021/12/5 17:54
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal differenceDenominator = BigDecimal.ZERO;

        //排除不在抽奖范围的奖品ID集合
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalValList = awardRateInfoMap.get(strategyId);

        //将awardRateIntervalValList中排除excludeAwardIds后剩下的放入differenceAwardRateList，并统计剩余的概率和
        for (AwardRateInfo awardRateInfo : awardRateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        //前置判断
        if (differenceAwardRateList.size() == 0) return "";
        if (differenceAwardRateList.size() == 1) return differenceAwardRateList.get(0).getAwardId();

        SecureRandom secureRandom = new SecureRandom();
        int randomV = secureRandom.nextInt(100) + 1;

        //循环获取奖品，临时算新的概率
        String awardId = "";
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate()
                    .divide(differenceDenominator, 2, BigDecimal.ROUND_UP)
                    .multiply(new BigDecimal(100)).intValue();

            if (randomV <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }

        return awardId;
    }
}
