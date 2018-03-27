package com.wiley.wpng.ref.user.api.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserAuthRepository extends CrudRepository<UserAuth, Long> {

    UserAuth findByLoginName(String loginName);
}
