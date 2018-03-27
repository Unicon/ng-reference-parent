package com.wiley.wpng.ref.common.user.api.auth;

import org.springframework.data.repository.CrudRepository;

public interface UserAuthRepository extends CrudRepository<UserAuth, Long> {

    UserAuth findByLoginName(String loginName);
}
