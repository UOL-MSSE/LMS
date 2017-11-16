package com.uol.msse.core.impl;


import com.uol.msse.core.Manage;
import com.uol.msse.data.UserInfo;
import com.uol.msse.exception.ManageUserException;
import com.uol.msse.page.AddUserPage;
import com.uol.msse.page.MainPage;
import com.uol.msse.page.UpdateUserPage;
import com.uol.msse.page.ViewUserPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

/**
 * Main class of execution
 */
public class Librarian implements Manage {

    @Override
    public void addUser(JMenuItem addUser, java.util.List<Map<String, UserInfo>> userInfos) throws ManageUserException {
        addUser.addActionListener((ActionEvent event) -> {
            new AddUserPage(userInfos);
        });
    }

    @Override
    public void viewUser(JMenuItem viewUser, java.util.List<Map<String, UserInfo>> userInfos) throws ManageUserException {
        viewUser.addActionListener((ActionEvent event) -> {
            new ViewUserPage(userInfos);
        });
    }

    @Override
    public void updateUser(JMenuItem updateUser, java.util.List<Map<String, UserInfo>> userInfos) throws ManageUserException{
        updateUser.addActionListener((ActionEvent event) ->  {
            new UpdateUserPage(userInfos);
        });
    }

}
