package com.herrhu.lottery.common;

/**
 * @description:枚举类型定义
 * @author: HerrHu
 * @time: 2021/12/4 21:32
 */
public class Constants {

    /**
     * 接口返回值定义
     */
    public enum ResponseCode {
        /**
         * 成功返回值
         */
        SUCCESS("0000", "成功"),
        UN_ERROR("0001", "未知失败"),
        ILLEGAL_PARAMETER("0002", "非法参数"),
        INDEX_DUP("0003", "主键冲突");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    /**
     * 抽奖策略模式：总体概率、单项概率
     * 场景：两种抽奖算法描述，场景A20%、B30%、C50%
     * 单项概率：如果A奖品抽空后，B和C保持目前中奖概率，用户抽奖扔有20%中为A，因A库存抽空则结果展示为未中奖。为了运营成本，通常这种情况的使用的比较多
     * 总体概率：如果A奖品抽空后，B和C奖品的概率按照 3:5 均分，相当于B奖品中奖概率由 0.3 升为 0.375
     */
    public enum StrategyMode {
        /**
         * 单项概率
         */
        SINGLE(1, "单项概率"),

        /**
         * 总体概率
         */
        ENTIRETY(2, "总体概率");


        private Integer code;
        private String info;

        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 中奖状态
     */
    public enum DrawState {
        /**
         * 未中奖（0）
         */
        FAIL(0, "未中奖"),
        SUCCESS(1, "已中奖"),
        COVER(2, "兜底奖");

        private Integer code;
        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 发奖状态
     */
    public enum AwardState {
        /**
         * 发奖状态
         */
        FAILURE(2, "发奖失败"),
        SUCCESS(1, "发奖成功"),
        WAIT(0, "等待发奖");

        private Integer code;
        private String info;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }
    }

    /**
     * 奖品类型
     */
    public enum AwardType {
        /**
         * 文字描述
         */
        DESC(1, "文字描述"),
        /**
         * 兑换码
         */
        RedeemCodeGoods(2, "兑换码"),
        /**
         * 优惠券
         */
        CouponGoods(3, "优惠券"),
        /**
         * 实物奖品
         */
        PhysicalGoods(4, "实物奖品");


        private Integer code;
        private String info;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }
    }
}
