package com.stackroute.service;

import com.stackroute.modal.DomainExpert;
import com.stackroute.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.DocAttribute;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    public AuthenticationServiceImpl() {
    }


    @Autowired
    AuthenticationRepository authenticationRepository;
//    @Override
//    public List<DomainExpert> getAllExperts() {
//        System.out.println(authenticationRepository.findAll());
//        return authenticationRepository.findAll();
//
//    }

    @Override
    public boolean authenticateDomainExpert(String userName, String password) {
        System.out.println(authenticationRepository.findAll());
        List<DomainExpert> domainExpert=authenticationRepository.findByUserName(userName,password);
        System.out.println(domainExpert);
        System.out.println(domainExpert.isEmpty());
     if(domainExpert.isEmpty()){
         return false;
     }else {
         return true;
     }

    }
}
