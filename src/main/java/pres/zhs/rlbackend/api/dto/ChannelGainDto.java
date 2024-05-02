package pres.zhs.rlbackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Controller传入数据实体类
 *
 * @author zhang haishuo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelGainDto implements Serializable {

    /**
     * 信道增益
     */
    private String channelGain;

    /**
     * 所能达到的价值最大值
     */
    private String actuallyVMax;

}
