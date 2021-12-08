package com.herrhu.lottery.infrastructure.repository;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.domain.activity.model.vo.*;
import com.herrhu.lottery.domain.activity.repository.IActivityRepository;
import com.herrhu.lottery.infrastructure.dao.IActivityDao;
import com.herrhu.lottery.infrastructure.dao.IAwardDao;
import com.herrhu.lottery.infrastructure.dao.IStrategyDao;
import com.herrhu.lottery.infrastructure.dao.IStrategyDetailDao;
import com.herrhu.lottery.infrastructure.po.Activity;
import com.herrhu.lottery.infrastructure.po.Award;
import com.herrhu.lottery.infrastructure.po.Strategy;
import com.herrhu.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/8 17:01
 */
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    IActivityDao activityDao;

    @Resource
    IAwardDao awardDao;

    @Resource
    IStrategyDao strategyDao;

    @Resource
    IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail detail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, detail);
            req.add(detail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId, ((Constants.ActivityState) beforeState).getCode(), ((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }
}
