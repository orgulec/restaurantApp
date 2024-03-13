package app.restaurantapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {
    private Long restaurantId;
    private Long userId;
    private Integer rating;
    private String opinion;
}
