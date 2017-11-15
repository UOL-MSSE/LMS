package com.uol.msse.core;


import com.uol.msse.data.Book;
import com.uol.msse.data.BookItem;
import com.uol.msse.data.UserInfo;

import java.util.List;

public interface Manage {

    void addUser(UserInfo userInfo);
    void updateUser(UserInfo userInfo);
    void deleteUser();
    List<UserInfo> getAllUsers();
    UserInfo getUserByFirstName();
    UserInfo getUserByLastName();
    void addBook(Book book);
    void addBookItem(BookItem bookItem);
    void updateBook(Book book);
    void updateBookItem(BookItem bookItem);

}
