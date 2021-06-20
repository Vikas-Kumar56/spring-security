package com.demo.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserDetailDao userDetailDao;

    @Autowired
    public UserDetailService(@Qualifier("UserDetailDaoFake") UserDetailDao userDetailDao) {
        this.userDetailDao = userDetailDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailDao.selectUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("%s user not found", username)));
    }
}
