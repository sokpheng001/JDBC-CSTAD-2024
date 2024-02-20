package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
    private Integer ItemId;
    private String ItemUuid;
    private String itemName;
}
