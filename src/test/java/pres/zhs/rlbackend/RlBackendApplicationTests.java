package pres.zhs.rlbackend;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.infra.dataobj.StrategyDo;
import pres.zhs.rlbackend.infra.gateway.ComputingStrategyImpl;

@SpringBootTest
class RlBackendApplicationTests {

    @Resource
    private ComputingStrategyImpl computingStrategy;

    @Test
    void contextLoads() {


        ChannelGainDto channelGainDto = new ChannelGainDto();
        channelGainDto.setChannelGain("6.06020304, 11.03319338, 0.10021354, 1.21610611, 1.96138838, 1.7145634, 5.2456357, 0.58953072, 4.07769429, 2.88333186");
        channelGainDto.setActuallyVMax("1");

        StrategyDo strategyDo = computingStrategy.computingStrategy(channelGainDto);
        System.out.println(strategyDo);
    }

}
