package com.uol.msse.page;


import com.uol.msse.core.Manage;
import com.uol.msse.core.impl.Librarian;
import com.uol.msse.data.UserInfo;
import com.uol.msse.exception.ManageUserException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class MainPage {

    private JFrame frame;

    private Librarian librarian;

    public MainPage() {
        librarian = new Librarian();
        init();
    }

    private void init() {
        List<Map<String, UserInfo>> userInfos = new ArrayList<>();

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

        JMenuItem viewUser = new JMenuItem("View User", new ImageIcon());
        userMgmtMenu.add(viewUser);

        JMenuItem updateUser = new JMenuItem("Update User", new ImageIcon());
        userMgmtMenu.add(updateUser);

        menubar.add(userMgmtMenu);

        /*JMenu libraryMgmtMenu = new JMenu("Library Management");
        JMenuItem addBook = new JMenuItem("Add Book", new ImageIcon());
        libraryMgmtMenu.add(addBook);
        JMenuItem updateBook = new JMenuItem("Update Book", new ImageIcon());
        libraryMgmtMenu.add(updateBook);
        JMenuItem viewBook = new JMenuItem("View Book", new ImageIcon());
        libraryMgmtMenu.add(viewBook);
        menubar.add(libraryMgmtMenu);*/

        JMenuItem exit = new JMenu("Exit").add(new JMenuItem("Exit"));
        menubar.add(Box.createHorizontalGlue());
        menubar.add(exit);

        exit.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        try {
            librarian.addUser(addUser, userInfos);
            librarian.viewUser(viewUser, userInfos);
            librarian.updateUser(updateUser, userInfos);
        } catch (ManageUserException mue) {
            System.out.println(mue.getMessage());
        }

        frame.setJMenuBar(menubar);

    }


    public static void main(String a[]) {
        EventQueue.invokeLater(() -> {
            new MainPage();
        });
    }

}
