package com.herrhu.lottery.domain.strategy.service.draw;

import com.herrhu.lottery.domain.strategy.model.req.DrawReq;
import com.herrhu.lottery.domain.strategy.model.res.DrawResult;

public interface IDrawExec {
    DrawResult doDrawExec(DrawReq req);
}
