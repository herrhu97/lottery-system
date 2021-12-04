package com.herrhu.lottery.rpc.res;

import com.herrhu.lottery.common.Result;
import com.herrhu.lottery.rpc.dto.ActivityDto;

import java.io.Serializable;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/4 21:45
 */
public class ActivityRes implements Serializable {
    private Result result;
    private ActivityDto activityDto;

    public ActivityRes(Result result, ActivityDto activityDto) {
        this.result = result;
        this.activityDto = activityDto;
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes() {
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ActivityDto getActivityDto() {
        return activityDto;
    }

    public void setActivityDto(ActivityDto activityDto) {
        this.activityDto = activityDto;
    }
}
