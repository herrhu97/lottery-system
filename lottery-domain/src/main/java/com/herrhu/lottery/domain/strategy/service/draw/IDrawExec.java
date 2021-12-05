package com.herrhu.lottery.domain.strategy.service.draw;

import com.herrhu.lottery.domain.strategy.model.req.DrawReq;
import com.herrhu.lottery.domain.strategy.model.res.DrawResult;

/**
 * @author herrhu
 */
public interface IDrawExec {
    /**
     * 
     * @param req
     * @return
     */
    DrawResult doDrawExec(DrawReq req);
}
