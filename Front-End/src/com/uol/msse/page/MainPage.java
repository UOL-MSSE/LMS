package com.uol.msse.page;


import com.uol.msse.data.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class MainPage  {

    private JFrame frame;

    public MainPage() {
        init();
    }

    private void init() {
        frame = new JFrame();
        frame.setTitle("Library Management System");
        //setSize(500, 200);
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JMenuBar menubar = new JMenuBar();

        JMenu userMgmtMenu = new JMenu("User Management");
        JMenuItem addUser = new JMenuItem("Add User", new ImageIcon());
        userMgmtMenu.add(addUser);
        JMenuItem updateUser = new JMenuItem("Update User", new ImageIcon());
        userMgmtMenu.add(updateUser);
        JMenuItem viewUser = new JMenuItem("View User", new ImageIcon());
        userMgmtMenu.add(viewUser);
        menubar.add(userMgmtMenu);

        JMenu libraryMgmtMenu = new JMenu("Library Management");
        JMenuItem addBook = new JMenuItem("Add Book", new ImageIcon());
        libraryMgmtMenu.add(addBook);
        JMenuItem updateBook = new JMenuItem("Update Book", new ImageIcon());
        libraryMgmtMenu.add(updateBook);
        JMenuItem viewBook = new JMenuItem("View Book", new ImageIcon());
        libraryMgmtMenu.add(viewBook);
        menubar.add(libraryMgmtMenu);
        menubar.add(libraryMgmtMenu);

        JMenuItem exit = new JMenu("Exit").add(new JMenuItem("Exit"));
        menubar.add(Box.createHorizontalGlue());
        menubar.add(exit);

        exit.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        java.util.List<UserInfo> userInfos = new ArrayList<>();

        addUser.addActionListener((ActionEvent event) -> {
             new AddUserPage(userInfos);
        });

        viewUser.addActionListener((ActionEvent event) -> {
            new ViewUserPage(userInfos);
        });

        frame.setJMenuBar(menubar);


        /*JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new AddUserPage(model));

        JButton updateUserButton = new JButton("Update User");
        addUserButton.addActionListener(new UpdateUserPage(model));

        JButton viewUserButton = new JButton("View User");
        addUserButton.addActionListener(new ViewUserPage(model));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        createLayout(addUserButton, updateUserButton, viewUserButton, closeButton);*/
    }





    public static void main(String a[]) {
        EventQueue.invokeLater(() -> {
            MainPage mainPage = new MainPage();
        });

    }

}
