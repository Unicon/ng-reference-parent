package com.wiley.wpng.ref.user.api.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {

    User findByLoginName(String loginName);
}
