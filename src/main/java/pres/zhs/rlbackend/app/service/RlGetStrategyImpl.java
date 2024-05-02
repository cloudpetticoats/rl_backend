package pres.zhs.rlbackend.app.service;

import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.api.dto.StrategyDto;
import pres.zhs.rlbackend.api.result.Re;
import pres.zhs.rlbackend.api.result.Result;
import pres.zhs.rlbackend.api.service.RlGetStrategy;
import pres.zhs.rlbackend.domain.service.DRlGetStrategyService;
import pres.zhs.rlbackend.infra.dataobj.StrategyDo;

@Service
public class RlGetStrategyImpl implements RlGetStrategy {

    @Resource
    private DRlGetStrategyService dRlGetStrategyService;

    @Override
    public Re<StrategyDto> getStrategy(ChannelGainDto channelGainDto) {

        StrategyDo strategyDo = dRlGetStrategyService.dRlGetStrategyService(channelGainDto);
        StrategyDto strategyDto = new StrategyDto();
        BeanUtils.copyProperties(strategyDo, strategyDto);
        strategyDto.setActuallyVMax(channelGainDto.getActuallyVMax());

        return Result.success(strategyDto);
    }
}
