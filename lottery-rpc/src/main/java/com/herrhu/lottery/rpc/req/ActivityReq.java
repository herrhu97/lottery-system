package com.herrhu.lottery.rpc.req;

import java.io.Serializable;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/4 21:44
 */
public class ActivityReq implements Serializable {
    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
