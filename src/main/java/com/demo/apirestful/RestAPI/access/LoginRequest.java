package com.demo.apirestful.RestAPI.access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    public String username;
    public String password;
}
