package com.demo.authentication.security;

import java.util.Optional;

public interface UserDetailDao {
    Optional<ApplicationUser> selectUserByUsername(String username);
}
