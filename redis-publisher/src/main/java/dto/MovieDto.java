package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mohamed ouokki on 11/5/22
 * @project redis-publisher
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Integer id;
    private String name;
    private String productionHouse;
}
