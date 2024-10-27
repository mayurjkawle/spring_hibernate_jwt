package com.Hibernate.Java.Hibernate.Service;

import com.Hibernate.Java.Hibernate.Entity.UserEntity;
import com.Hibernate.Java.Hibernate.Repository.UserEntiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserEntiryRepository userRepository;
    public List<UserEntity> getUsers(){
        List<UserEntity> users = null;

        Iterable<UserEntity> userList = userRepository.findAll();
        return (List<UserEntity>) userList;
//        return users;
    }

    public UserEntity getuser(Long userId){
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }

    public UserEntity addUser(UserEntity user){

        UserEntity result = userRepository.save(user);
        System.out.println("This is the Result : "+ result);
        return result;
    }

    public boolean deleteUser(Long userId){
//        UserEntity user = UserEntity.builder().id(userId).build();
        userRepository.deleteById(userId);
        return true;
    }

    public List<UserEntity> getUsersBy(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public List<UserEntity> getUserByCustomQuery(String username){
        return userRepository.findByUsernameContaining(username);
    }
}
