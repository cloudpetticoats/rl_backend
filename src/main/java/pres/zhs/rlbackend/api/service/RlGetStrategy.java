package pres.zhs.rlbackend.api.service;

import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.api.dto.StrategyDto;
import pres.zhs.rlbackend.api.result.Re;

public interface RlGetStrategy {

    Re<StrategyDto> getStrategy(ChannelGainDto strategyDto);
}
