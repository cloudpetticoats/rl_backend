package pres.zhs.rlbackend.app.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.zhs.rlbackend.api.dto.ChannelGainDto;
import pres.zhs.rlbackend.api.dto.StrategyDto;
import pres.zhs.rlbackend.api.result.Re;
import pres.zhs.rlbackend.api.service.RlGetStrategy;

@RestController
@RequestMapping("/drl")
public class RLController {

    @Resource
    private RlGetStrategy rlGetStrategy;

    @PostMapping("/getStrategy")
    public Re<StrategyDto> getStrategy(@RequestBody ChannelGainDto channelGainDto) {
        return rlGetStrategy.getStrategy(channelGainDto);
    }
}
