package model;

import lombok.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private Integer OrderId;
    private String OrderUuid;
    private Date localDateTime;
    // one ordDER is for one person
    private User userId;
    // many to many
    private List<Item> itemId;
}
