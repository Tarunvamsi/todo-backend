package com.vamsi.todo.repository;

import com.vamsi.todo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{userName:'?0'}")
    User findUserByUserName(String userName);
}
