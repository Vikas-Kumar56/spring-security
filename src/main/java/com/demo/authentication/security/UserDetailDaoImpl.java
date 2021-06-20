package com.demo.authentication.security;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.demo.authentication.security.UserRole.*;

@Repository("UserDetailDaoFake")
public class UserDetailDaoImpl implements UserDetailDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectUserByUsername(String username) {
        return getUsers().stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    private List<ApplicationUser> getUsers()  {
        return Lists.newArrayList(
                new ApplicationUser(
                        ADMIN.getAuthorities(),
                        passwordEncoder.encode("password"),
                        "vikas",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        STUDENT.getAuthorities(),
                        passwordEncoder.encode("password"),
                        "amol",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMINTRAINEE.getAuthorities(),
                        passwordEncoder.encode("password"),
                        "trainee",
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
