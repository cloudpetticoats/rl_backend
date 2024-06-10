package pres.zhs.rlbackend.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pres.zhs.rlbackend.api.dto.ChannelDataObj;
import pres.zhs.rlbackend.infra.readfile.ReadFile;

import java.util.List;

@Configuration
public class GetDataConfig {

    @Bean
    public List<ChannelDataObj> allFileData() {
        return ReadFile.readFile();
    }
}
