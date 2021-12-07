package com.herrhu.lottery.domain.award.service.goods.impl;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.domain.award.model.req.GoodsReq;
import com.herrhu.lottery.domain.award.model.res.DistributionRes;
import com.herrhu.lottery.domain.award.service.goods.DistributionBase;
import com.herrhu.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/7 19:06
 */
@Component
public class RedeemCodeGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        // 模拟调用兑换码
        logger.info("模拟调用兑换码 uId：{} awardContent：{}", req.getuId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }
}
