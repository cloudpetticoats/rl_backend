package pres.zhs.rlbackend.app.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import pres.zhs.rlbackend.api.dto.DataDto;
import pres.zhs.rlbackend.api.dto.PostDto;
import pres.zhs.rlbackend.api.result.Re;
import pres.zhs.rlbackend.api.service.GetData;

@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    private GetData getData;

    @PostMapping("/getData")
    public Re<DataDto> getData(@RequestBody PostDto page) {
        return getData.getData(page.getPage());
    }
}
