package com.herrhu.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import com.herrhu.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/9 19:09
 */
@Mapper
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);
}
