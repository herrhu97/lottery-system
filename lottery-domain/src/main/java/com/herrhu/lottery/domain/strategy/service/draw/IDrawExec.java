package com.herrhu.lottery.domain.strategy.service.draw;

import com.herrhu.lottery.domain.strategy.model.req.DrawReq;
import com.herrhu.lottery.domain.strategy.model.res.DrawResult;

/**
 * @author herrhu
 * @description 执行抽奖接口
 */
public interface IDrawExec {
    /**
     * 抽奖方法
     *
     * @param req 抽奖参数：用户ID、策略ID
     * @return 中奖结果
     */
    DrawResult doDrawExec(DrawReq req);
}
