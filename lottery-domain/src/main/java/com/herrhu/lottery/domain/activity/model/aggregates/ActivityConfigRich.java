package com.herrhu.lottery.domain.activity.model.aggregates;

import com.herrhu.lottery.domain.activity.model.vo.ActivityVO;
import com.herrhu.lottery.domain.activity.model.vo.AwardVO;
import com.herrhu.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/8 14:40
 */
public class ActivityConfigRich {
    /**
     * 活动配置
     */
    private ActivityVO activity;

    /**
     * 策略配置(含策略明细)
     */
    private StrategyVO strategy;

    /**
     * 奖品配置
     */
    private List<AwardVO> awardList;

    public ActivityVO getActivity() {
        return activity;
    }

    public void setActivity(ActivityVO activity) {
        this.activity = activity;
    }

    public StrategyVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyVO strategy) {
        this.strategy = strategy;
    }

    public List<AwardVO> getAwardList() {
        return awardList;
    }

    public void setAwardList(List<AwardVO> awardList) {
        this.awardList = awardList;
    }

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }
}
