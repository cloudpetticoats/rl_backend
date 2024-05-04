package pres.zhs.rlbackend.infra.gateway;

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

    @Override
    public DataDto getData() {

        List<ChannelDataObj> dataObjs = ReadFile.readFile();

        Random random = new Random();
        int x = random.nextInt(29000);

        List<ChannelDataObj> fiveData = new ArrayList<>();
        for (int i = x; i < x + 5; i++) {
            fiveData.add(dataObjs.get(i));
        }

        return DataDto.builder().data(fiveData).build();
    }

    @Override
    public List<ChannelDataObj> getAllData() {
        return ReadFile.readFile();
    }
}
