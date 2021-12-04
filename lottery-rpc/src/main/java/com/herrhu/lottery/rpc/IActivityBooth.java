package com.herrhu.lottery.rpc;

import com.herrhu.lottery.rpc.req.ActivityReq;
import com.herrhu.lottery.rpc.res.ActivityRes;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/4 21:46
 */
public interface IActivityBooth {
    ActivityRes queryActivityId(ActivityReq activityReq);
}
