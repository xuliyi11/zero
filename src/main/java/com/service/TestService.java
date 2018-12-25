package com.service;

import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TestService {

    List<User> getUser(int id);

}
