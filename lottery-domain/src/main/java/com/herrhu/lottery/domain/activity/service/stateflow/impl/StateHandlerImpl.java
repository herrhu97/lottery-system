package com.herrhu.lottery.domain.activity.service.stateflow.impl;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.common.Result;
import com.herrhu.lottery.domain.activity.service.stateflow.IStateHandler;
import com.herrhu.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/8 16:16
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).arraignment(activityId, currentState);
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).checkPass(activityId, currentState);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).checkRefuse(activityId, currentState);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).checkRevoke(activityId, currentState);
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).close(activityId, currentState);
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).close(activityId, currentState);
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return stateGroup.get(currentState).doing(activityId, currentState);
    }
}
