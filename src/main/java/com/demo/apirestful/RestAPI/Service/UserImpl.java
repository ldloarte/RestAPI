package com.demo.apirestful.RestAPI.Service;

import com.demo.apirestful.RestAPI.access.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.apirestful.RestAPI.repository.userRepository;
import com.demo.apirestful.RestAPI.access.User;
@Service
public class UserImpl implements userService {

    @Autowired
    private userRepository userRepository;

    @Override
    public Boolean findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null){
            return Boolean.TRUE;
        } else{
            return Boolean.FALSE;
        }
    }
}
