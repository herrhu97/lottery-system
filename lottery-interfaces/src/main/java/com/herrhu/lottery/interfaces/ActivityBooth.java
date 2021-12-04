package com.herrhu.lottery.interfaces;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.common.Result;
import com.herrhu.lottery.infrastructure.dao.IActivityDao;
import com.herrhu.lottery.infrastructure.po.Activity;
import com.herrhu.lottery.rpc.IActivityBooth;
import com.herrhu.lottery.rpc.dto.ActivityDto;
import com.herrhu.lottery.rpc.req.ActivityReq;
import com.herrhu.lottery.rpc.res.ActivityRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityId(ActivityReq activityReq) {
        Activity activity = activityDao.queryActivityById(activityReq.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());


        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(),
                Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}
