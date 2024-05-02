package pres.zhs.rlbackend.domain.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.domain.gateway.ComputingStrategy;
import pres.zhs.rlbackend.infra.dataobj.StrategyDo;

/**
 * domain层核心处理逻辑
 *
 * @author 张海硕
 */
@Service
public class DRlGetStrategyService {

    @Resource
    private ComputingStrategy computingStrategy;

    public StrategyDo dRlGetStrategyService(ChannelGainDto channelGainDto) {

        return computingStrategy.computingStrategy(channelGainDto);
    }

}
