package com.herrhu.lottery.domain.strategy.model.vo;

/**
 * @description:
 * @author: HerrHu
 * @time: 2021/12/5 22:58
 */
public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容「描述、奖品码、sku」
     */
    private String awardContent;

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String rewardId, String awardName) {
        this.awardId = rewardId;
        this.awardName = awardName;
    }

    public DrawAwardInfo(String awardId, Integer awardType, String awardName, String awardContent) {
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
