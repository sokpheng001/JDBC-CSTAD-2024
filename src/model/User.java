package model;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer UserId;
    private String UserUuid;
    private String userName;
    private String email;
    private String password;
    private Boolean isDeleted;
}
