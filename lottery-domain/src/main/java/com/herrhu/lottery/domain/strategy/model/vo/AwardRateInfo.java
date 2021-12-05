package com.herrhu.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * @description: 奖品概率信息，奖品编号、库存、概率
 * @author: HerrHu
 * @time: 2021/12/5 14:46
 */
public class AwardRateInfo {

    //奖品id
    private String awardId;

    //中奖概率
    private BigDecimal awardRate;

    public AwardRateInfo() {
    }

    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}
