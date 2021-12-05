package com.herrhu.lottery.domain.strategy.model.req;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/5 14:46
 */
public class DrawReq {
    //用户id
    private String uId;

    //策略id
    private Long strategyId;

    public DrawReq() {
    }

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
