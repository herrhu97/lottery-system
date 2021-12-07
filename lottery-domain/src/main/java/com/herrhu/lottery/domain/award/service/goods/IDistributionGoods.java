package com.herrhu.lottery.domain.award.service.goods;

import com.herrhu.lottery.domain.award.model.req.GoodsReq;
import com.herrhu.lottery.domain.award.model.res.DistributionRes;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/7 19:05
 */
public interface IDistributionGoods {

    /**
     * 奖品配送接口，奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     *
     * @param req
     * @return
     */
    DistributionRes doDistribution(GoodsReq req);
}
