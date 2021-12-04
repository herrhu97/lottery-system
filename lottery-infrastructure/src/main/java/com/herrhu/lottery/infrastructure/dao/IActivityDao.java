package com.herrhu.lottery.infrastructure.dao;

import com.herrhu.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/4 21:49
 */
@Mapper
public interface IActivityDao {
    void insert(Activity req);

    Activity queryActivityById(Long id);
}
