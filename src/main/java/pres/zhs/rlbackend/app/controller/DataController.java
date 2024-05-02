package pres.zhs.rlbackend.app.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.zhs.rlbackend.api.dto.DataDto;
import pres.zhs.rlbackend.api.result.Re;
import pres.zhs.rlbackend.api.service.GetData;

@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    private GetData getData;

    @PostMapping("/getData")
    public Re<DataDto> getData() {
        return getData.getData();
    }
}
