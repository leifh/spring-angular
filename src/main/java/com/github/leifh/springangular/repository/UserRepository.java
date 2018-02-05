package com.github.leifh.springangular.repository;

import com.github.leifh.springangular.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


    @Query("select u from User u left join fetch u.roles where u.username = ?1")
    public User findByUsername(String username);
}
