package com.stackroute.service;

import com.stackroute.modal.DomainExpert;

import java.util.List;

public interface AuthenticationService {
    //method to check if the DomainExpert Credentials are correct or not
    boolean authenticateDomainExpert(String userName, String password);
}
