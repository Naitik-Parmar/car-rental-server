package com.oop.carrentalspring.services.auth;

import com.oop.carrentalspring.dto.SignupRequest;
import com.oop.carrentalspring.dto.UserDto;

public interface AuthService {
    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
