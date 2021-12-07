package com.herrhu.lottery.domain.strategy.service.draw;

import com.herrhu.lottery.common.Constants;
import com.herrhu.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.herrhu.lottery.domain.strategy.model.req.DrawReq;
import com.herrhu.lottery.domain.strategy.model.res.DrawResult;
import com.herrhu.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.herrhu.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.herrhu.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.herrhu.lottery.infrastructure.po.Award;
import com.herrhu.lottery.infrastructure.po.Strategy;
import com.herrhu.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 定义抽象过程，模板模式
 * @author: HerrHu
 * @time: 2021/12/5 18:18
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        //1. 获取抽奖策略配置数据
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        //2. 校验和初始化数据
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        //3. 获取不在抽奖范围内的列表
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());

        //4. 执行抽奖算法
        String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmGroup.get(strategy.getStrategyMode()), excludeAwardIds);

        //5. 封装结果
        return buildDrawResult(req.getuId(), req.getStrategyId(), awardId);
    }


    /**
     * 校验抽奖结果是否初始化到内存
     *
     * @param strategyId         策略ID
     * @param strategyMode       策略模式
     * @param strategyDetailList 策略详情
     */
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {

        //非单项概率，不必存入缓存
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }
        IDrawAlgorithm drawAlgorithm = drawAlgorithmGroup.get(strategyMode);

        //已初始化过的数据，不必重复初始化
        if (drawAlgorithm.isExistRateTuple(strategyId)) {
            return;
        }

        //解析并初始化中奖概率到散列表
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

    /**
     * 获取不在抽奖范围内的列表，比如库存为空、风控策略，由具体的实现决定
     *
     * @param strategyId 策略id
     * @return 应该排除的奖品id
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 执行抽奖算法
     *
     * @param strategyId      策略id
     * @param iDrawAlgorithm  策略算法
     * @param excludeAwardIds 排除的奖品id
     * @return 中奖id
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm iDrawAlgorithm, List<String> excludeAwardIds);

    /**
     * 包装抽奖结果
     *
     * @param uId        用户id
     * @param strategyId 策略id
     * @param awardId    奖品id
     * @return 抽奖结果
     */
    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId) {

        if (null == awardId) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        Award award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        logger.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}",
                uId, strategyId, awardId, award.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }
}
