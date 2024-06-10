package pres.zhs.rlbackend.domain.service;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pres.zhs.rlbackend.api.dto.ChannelDataObj;
import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.api.dto.StrategyDto;
import pres.zhs.rlbackend.domain.gateway.ComputingStrategy;
import pres.zhs.rlbackend.domain.gateway.GetDataGateway;
import pres.zhs.rlbackend.infra.dataobj.StrategyDo;
import pres.zhs.rlbackend.infra.websocket.WebSocketServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * domain层核心处理逻辑
 *
 * @author 张海硕
 */
@Service
public class DRlGetStrategyService {

    @Resource
    private ComputingStrategy computingStrategy;

    @Resource
    private GetDataGateway getDataGateway;

    @Resource
    private WebSocketServer webSocketServer;

    @Resource
    private List<ChannelDataObj> allFileData;

//    private static final ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
    private static final int loop = 30000;
    private static final int timeFrame = 2000;

    public StrategyDo dRlGetStrategyService(ChannelGainDto channelGainDto) {
        return computingStrategy.computingStrategy(channelGainDto);
    }

    public String startSimulate(String name) {

//        List<ChannelDataObj> allData = getDataGateway.getAllData();

        List<ChannelGainDto> data = new ArrayList<>(30000);
        for (ChannelDataObj item : allFileData) {
            ChannelGainDto build = ChannelGainDto.builder()
                    .channelGain(item.getChannel())
                    .actuallyVMax(item.getActuallyVMax())
                    .build();
            data.add(build);
        }

        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);

        Runnable task = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                if (count < loop) {
                    count++;
                    StrategyDo strategyDo = computingStrategy.computingStrategy(data.get(count));
                    StrategyDto strategy = StrategyDto.builder().actuallyVMax(data.get(count).getActuallyVMax()).build();
                    BeanUtils.copyProperties(strategyDo, strategy);
                    try {
                        webSocketServer.AppointSending(name, JSON.toJSONString(strategy));
                    } catch (Exception e) {
                        service.shutdown();
                        throw new RuntimeException(e);
                    }
                } else {
                    service.shutdown();
                }
            }
        };

        service.scheduleAtFixedRate(task, 1, timeFrame, TimeUnit.MILLISECONDS);

        return "starting simulation";
    }
}
