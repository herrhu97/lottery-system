package com.herrhu.lottery.domain.support.ids.policy;

import com.herrhu.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @description: 短码生成策略，仅支持很小的调用量，用于生成活动配置类编号，保证全局唯一
 * @author: HerrHu
 * @time: 2021/12/8 21:39
 */
@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public synchronized long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
