package pres.zhs.rlbackend.domain.gateway;

import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.infra.dataobj.StrategyDo;

public interface ComputingStrategy {

    StrategyDo computingStrategy(ChannelGainDto channelGainDto);
}
