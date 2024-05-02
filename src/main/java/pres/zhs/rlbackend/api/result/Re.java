package pres.zhs.rlbackend.api.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Re<T> {

    private Integer code;

    private String msg;

    private T data;
}
