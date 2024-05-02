package pres.zhs.rlbackend.infra.dataobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyDo implements Serializable {

    private String offloadingStrategy;

    private String timeAllocation;

    private String vMax;

    private String computingTime;
}
