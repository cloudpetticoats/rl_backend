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
public class StrategyDto implements Serializable {

    private String offloadingStrategy;

    private String timeAllocation;

    private String vMax;

    private String actuallyVMax;

    private String computingTime;
}
