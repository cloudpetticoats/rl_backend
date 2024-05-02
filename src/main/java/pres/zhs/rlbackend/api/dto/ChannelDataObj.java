package pres.zhs.rlbackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelDataObj implements Serializable {

    private String channel;

    private String actuallyVMax;
}
