package pres.zhs.rlbackend.infra.gateway;

import org.springframework.stereotype.Component;
import pres.zhs.rlbackend.api.dto.ChannelDataObj;
import pres.zhs.rlbackend.api.dto.DataDto;
import pres.zhs.rlbackend.domain.gateway.GetDataGateway;
import pres.zhs.rlbackend.infra.readfile.ReadMatFile;

import java.util.List;

@Component
public class GetDataGatewayImpl implements GetDataGateway {

    @Override
    public DataDto getData() {

        List<ChannelDataObj> dataObjs = ReadMatFile.readMatFile();

        return DataDto.builder().data(dataObjs).build();
    }
}
