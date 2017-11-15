package com.uol.msse.core.impl;


import com.uol.msse.core.Manage;
import com.uol.msse.core.Search;
import com.uol.msse.data.Book;
import com.uol.msse.data.BookItem;
import com.uol.msse.data.UserInfo;
import com.uol.msse.entity.Format;

import java.util.List;

public class Librarian implements Manage, Search {

    @Override
    public void addUser(UserInfo userInfo) {

    }

    @Override
    public void updateUser(UserInfo userInfo) {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public List<UserInfo> getAllUsers() {
        return null;
    }

    @Override
    public UserInfo getUserByFirstName() {
        return null;
    }

    @Override
    public UserInfo getUserByLastName() {
        return null;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void addBookItem(BookItem bookItem) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void updateBookItem(BookItem bookItem) {

    }

    @Override
    public List<BookItem> getAllByTitle(String title) {
        return null;
    }

    @Override
    public List<BookItem> getAllByFormat(Format format) {
        return null;
    }

    @Override
    public List<BookItem> getByUserName(String firstName, String lastName) {
        return null;
    }
}
