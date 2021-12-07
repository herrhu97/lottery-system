package com.herrhu.lottery.domain.award.service.factory;

import com.herrhu.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/7 19:04
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig {

    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }
}
