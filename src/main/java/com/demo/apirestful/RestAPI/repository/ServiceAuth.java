package com.demo.apirestful.RestAPI.repository;

import com.demo.apirestful.RestAPI.Registro.RegisterRequest;
import com.demo.apirestful.RestAPI.access.LoginRequest;
import com.demo.apirestful.RestAPI.jwt.Authresponse;

public interface ServiceAuth {
    Authresponse register (RegisterRequest request);

    Authresponse login (LoginRequest request);
}
