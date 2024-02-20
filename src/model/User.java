package model;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private Boolean isDeleted;
}
