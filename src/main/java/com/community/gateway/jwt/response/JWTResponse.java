package com.community.gateway.jwt.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JWTResponse {
    private String token;
    private String type = "GateWay";
    private Long id;
    private String username;
    private String mobileNumber;
    private String roles;
    private String msg;

    public JWTResponse(String accessToken, Long id, String username, String mobileNumber, String roles, String msg) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.roles = roles;
        this.msg = msg;
    }

    public JWTResponse(String message) {
        this.msg = message;
    }
}
