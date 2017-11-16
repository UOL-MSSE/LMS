package com.uol.msse.core;


import com.uol.msse.data.Book;
import com.uol.msse.data.BookItem;
import com.uol.msse.data.UserInfo;
import com.uol.msse.exception.ManageUserException;

import javax.swing.*;
import java.util.List;
import java.util.Map;

// Interface for operations of admin for managing user accounts and books
public interface Manage {

    // Create user
    void addUser(JMenuItem addUser, java.util.List<Map<String, UserInfo>> userInfos) throws ManageUserException;

    // View user
    void viewUser(JMenuItem viewUser, java.util.List<Map<String, UserInfo>> userInfos) throws ManageUserException;

    // update user
    void updateUser(JMenuItem updateUser, java.util.List<Map<String, UserInfo>> userInfos) throws ManageUserException;

    /*void deleteUser();
    List<UserInfo> getAllUsers();
    UserInfo getUserByFirstName();
    UserInfo getUserByLastName();
    void addBook(Book book);
    void addBookItem(BookItem bookItem);
    void updateBook(Book book);
    void updateBookItem(BookItem bookItem);
*/
}
