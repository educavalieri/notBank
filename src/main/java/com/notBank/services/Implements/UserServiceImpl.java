package com.notBank.services.Implements;

import com.notBank.dtos.UserDto;
import com.notBank.entities.User;
import com.notBank.mappers.UserMapper;
import com.notBank.repositories.UserRepository;
import com.notBank.services.UserService;
import javax.transaction.Transactional;

import com.notBank.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

//    @Autowired
//    private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthService authService;


    private static Logger logger = LoggerFactory.getLogger(UserService.class);

//    @Override
//    public UserDto findById(Long id) throws Exception {
//        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
//        return UserMapper.toDto(user);
//    }

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        return users.stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(UserDto dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDto save(UserDto dto) {
        User user = UserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return UserMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public UserDto findById(Long id){

        authService.validateSelfOrAdmin(id);

        User entity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserMapper.toDto(entity);

    }

    @Transactional
    public UserDto findUserAuthenticated(){

        User user = authService.Authenticated();
        User entity = userRepository.findByEmail(user.getUsername());
        return UserMapper.toDto(entity);

    }


    //-----------------------------------------------------------------------------------
    //authentication zone:

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null){
            logger.error("user not found " + username);
            throw new UsernameNotFoundException("email not found");
        }
        logger.info("user found" + username);
        return user;
    }


}
