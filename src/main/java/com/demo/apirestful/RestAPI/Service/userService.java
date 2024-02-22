package com.demo.apirestful.RestAPI.Service;

import com.demo.apirestful.RestAPI.access.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.demo.apirestful.RestAPI.repository.userRepository;
import java.util.Optional;

public interface userService {

    Boolean findByEmail(String email);

}
