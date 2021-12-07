package com.herrhu.lottery.domain.strategy.model.res;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.domain.strategy.model.vo.DrawAwardInfo;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/5 14:46
 */
public class DrawResult {
    //用户id
    private String uId;

    //策略id
    private Long strategyId;

    /**
     * 中奖状态（默认未中奖）
     */
    private Integer drawState = Constants.DrawState.FAIL.getCode();

    //奖品名称
    private DrawAwardInfo drawAwardInfo;

    public DrawResult() {
    }

    public DrawResult(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
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

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
