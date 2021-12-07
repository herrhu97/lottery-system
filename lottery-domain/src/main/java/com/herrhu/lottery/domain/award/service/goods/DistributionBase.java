package com.herrhu.lottery.domain.award.service.goods;

import com.herrhu.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @description: 配送货物基础共用类
 * @author: HerrHu
 * @time: 2021/12/7 19:05
 */
public class DistributionBase {
    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        logger.info("TODO 后期添加更新分库分表，用户个人的抽奖记录表中奖品发奖状态 uID: {}", uId);
    }
}
