package com.herrhu.lottery.domain.award.service.factory;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.domain.award.service.goods.IDistributionGoods;
import com.herrhu.lottery.domain.award.service.goods.impl.CouponGoods;
import com.herrhu.lottery.domain.award.service.goods.impl.DescGoods;
import com.herrhu.lottery.domain.award.service.goods.impl.PhysicalGoods;
import com.herrhu.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/7 19:04
 */
public class GoodsConfig {
    protected Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private DescGoods descGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
    }
}
