package ecommerce.product.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private String error;
    private String details;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorDetails(String error, String details) {
        super();
        this.error = error;
        this.details = details;
    }

}
