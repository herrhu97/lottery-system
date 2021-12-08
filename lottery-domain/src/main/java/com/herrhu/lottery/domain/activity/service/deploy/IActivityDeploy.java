package com.herrhu.lottery.domain.activity.service.deploy;

import com.herrhu.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/8 14:42
 */
public interface IActivityDeploy {
    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);
}
