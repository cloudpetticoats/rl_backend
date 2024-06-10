package pres.zhs.rlbackend.infra.gateway;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import pres.zhs.rlbackend.api.dto.ChannelDataObj;
import pres.zhs.rlbackend.api.dto.DataDto;
import pres.zhs.rlbackend.domain.gateway.GetDataGateway;
import pres.zhs.rlbackend.infra.readfile.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class GetDataGatewayImpl implements GetDataGateway {

    @Resource
    private List<ChannelDataObj> allFileData;

    @Override
    public DataDto getData(Integer page) {
        List<ChannelDataObj> fiveData = new ArrayList<>();
        for (int i = page * 5 - 5; i < page * 5; i++) {
            fiveData.add(allFileData.get(i));
        }

        return DataDto.builder().data(fiveData).build();
    }

    @Override
    public List<ChannelDataObj> getAllData() {
        return ReadFile.readFile();
    }
}
