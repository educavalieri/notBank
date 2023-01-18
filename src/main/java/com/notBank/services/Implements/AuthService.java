package com.notBank.services.Implements;

import com.notBank.entities.User;
import com.notBank.repositories.UserRepository;
import com.notBank.services.exceptions.ForbiddenException;
import com.notBank.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public User Authenticated() {

        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepository.findByEmail(userName);
            return user;
        }catch (Exception e){
            throw new UnauthorizedException("invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId){
        User user = Authenticated();
        if (!user.getId().equals(userId) && !user.hasHole("ROLE_ADMIN")){
            throw new ForbiddenException("Access denied");
        }


    }


}
