package com.herrhu.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import com.herrhu.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/9 19:08
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {
    /**
     * 新增数据
     *
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     *
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);
}
