package com.herrhu.lottery.infrastructure.dao;

import com.herrhu.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 策略表数据库操作
 *
 * @author herrhu
 */
@Mapper
public interface IStrategyDetailDao {

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    int deductStock(StrategyDetail req);
}
