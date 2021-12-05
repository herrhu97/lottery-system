package com.herrhu.lottery.infrastructure.dao;

import com.herrhu.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);
}
