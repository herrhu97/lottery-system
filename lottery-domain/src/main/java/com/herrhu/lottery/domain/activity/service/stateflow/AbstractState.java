package com.herrhu.lottery.domain.activity.service.stateflow;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.common.Result;
import com.herrhu.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * 状态模式：类的行为基于它的状态改变的
 *
 * @description:
 * @author: HerrHu
 * @time: 2021/12/8 14:44
 */
public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    /**
     * 活动提审
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return 执行结果
     */
    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核通过
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return
     */
    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核拒绝
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return
     */
    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 撤审取消
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return
     */
    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动关闭
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动开启
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return
     */
    public abstract Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动执行
     *
     * @param activityId   活动ID
     * @param currentState 当前状态
     * @return
     */
    public abstract Result doing(Long activityId, Enum<Constants.ActivityState> currentState);
}
