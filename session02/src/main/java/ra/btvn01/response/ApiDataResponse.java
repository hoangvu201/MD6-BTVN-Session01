package ra.btvn01.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiDataResponse<T> {
    private Boolean success;
    private String message;
    private T data;
    private String errors;
    private HttpStatus status;
}
