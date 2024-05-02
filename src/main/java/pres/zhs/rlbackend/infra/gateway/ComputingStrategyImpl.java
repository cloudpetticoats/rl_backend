package pres.zhs.rlbackend.infra.gateway;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.domain.gateway.ComputingStrategy;
import pres.zhs.rlbackend.infra.dataobj.StrategyDo;
import pres.zhs.rlbackend.infra.websocket.WebSocketClient;

@Component
public class ComputingStrategyImpl implements ComputingStrategy {

    // 构建实例
    private WebSocketClient wsClient = WebSocketClient.getInstance();

    @Override
    public StrategyDo computingStrategy(ChannelGainDto channelGainDto) {


        // 发送消息，接收返回值
        String result = wsClient.sendStr(channelGainDto.getChannelGain());
        StrategyDo strategyDo = null;
        if (result != null) {
            strategyDo = JSON.parseObject(result, StrategyDo.class);
        }

        return strategyDo;
    }
}
