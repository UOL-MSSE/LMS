package com.uol.msse.core;


import com.uol.msse.data.UserInfo;

public interface User {
    User addUser(UserInfo userInfo);
    void deleteUSer();
}
