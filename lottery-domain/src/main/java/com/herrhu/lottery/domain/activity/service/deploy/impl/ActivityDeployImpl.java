package com.herrhu.lottery.domain.activity.service.deploy.impl;

import com.alibaba.fastjson.JSON;
import com.herrhu.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.herrhu.lottery.domain.activity.model.req.ActivityConfigReq;
import com.herrhu.lottery.domain.activity.model.vo.ActivityVO;
import com.herrhu.lottery.domain.activity.model.vo.AwardVO;
import com.herrhu.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.herrhu.lottery.domain.activity.model.vo.StrategyVO;
import com.herrhu.lottery.domain.activity.repository.IActivityRepository;
import com.herrhu.lottery.domain.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/8 16:38
 */
@Service
public class ActivityDeployImpl implements IActivityDeploy {
    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("创建活动配置开始，activityId:{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try {
            //添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            //添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            //添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            //添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("创建活动配置完成，activityId：{}", req.getActivityId());
        } catch (DuplicateKeyException e) {
            logger.error("创建活动配置失败，唯一索引冲突activityId：{} reqJson: {}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        //TODO:非核心功能后续补充
    }
}
