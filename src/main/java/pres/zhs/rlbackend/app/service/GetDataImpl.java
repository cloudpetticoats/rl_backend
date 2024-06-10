package pres.zhs.rlbackend.app.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pres.zhs.rlbackend.api.dto.DataDto;
import pres.zhs.rlbackend.api.result.Re;
import pres.zhs.rlbackend.api.result.Result;
import pres.zhs.rlbackend.api.service.GetData;
import pres.zhs.rlbackend.domain.gateway.GetDataGateway;

@Service
public class GetDataImpl implements GetData {

    @Resource
    private GetDataGateway getDataGateway;

    @Override
    public Re<DataDto> getData(Integer page) {

        DataDto data = getDataGateway.getData(page);

        return Result.success(data);
    }
}
