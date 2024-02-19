package io.cloudtype.Demo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //스네이크 케이스 적용하는거
public class UserRequest {
    private String userName;

    private Integer userAge;

    private String userEmail;

    private Boolean isKorean; // is_korean

    /*public String getname(){
        return this.userName;
    }
    public int gethumanAge(){
        return this.userAge;
    }*/

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Boolean getIsKorean() {
        return isKorean;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userEmail='" + userEmail + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
}