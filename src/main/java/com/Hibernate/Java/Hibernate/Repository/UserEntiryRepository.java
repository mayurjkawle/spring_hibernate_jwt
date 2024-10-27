package com.Hibernate.Java.Hibernate.Repository;

import com.Hibernate.Java.Hibernate.Entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserEntiryRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findByUsernameAndPassword(String username, String password);

//    @Query(value = "select * from user_entity where username like '%:username%'" , nativeQuery = true)
//    List<UserEntity> getUserByUsernameLike(@Param("username") String username);
    @Query(value = "SELECT * FROM user_entity WHERE username LIKE %:username%", nativeQuery = true)
    List<UserEntity> findByUsernameContaining(@Param("username") String username);

}
