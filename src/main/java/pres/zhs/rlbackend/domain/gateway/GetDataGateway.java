package pres.zhs.rlbackend.domain.gateway;

import pres.zhs.rlbackend.api.dto.ChannelDataObj;
import pres.zhs.rlbackend.api.dto.DataDto;

import java.util.List;

public interface GetDataGateway {

    DataDto getData();

    List<ChannelDataObj> getAllData();
}
