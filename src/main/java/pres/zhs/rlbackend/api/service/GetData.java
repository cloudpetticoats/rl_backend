package pres.zhs.rlbackend.api.service;

import pres.zhs.rlbackend.api.dto.DataDto;
import pres.zhs.rlbackend.api.result.Re;

public interface GetData {

    Re<DataDto> getData();
}
