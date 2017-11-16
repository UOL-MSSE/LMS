package com.uol.msse.page;


import com.uol.msse.data.UserInfo;
import com.uol.msse.exception.ManageUserException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class FormPage extends JPanel {

    protected JTextField[] fields;
    protected String[] labels = { "User Id", "First Name", "Last Name"};
    protected int[] widths = { 15, 15, 15 };


    public FormPage(){
    }

    public FormPage(String[] labels, int[] widths, Map<String, UserInfo> userInfo) throws ManageUserException{
        super(new BorderLayout());

        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        fields = new JTextField[labels.length];

        if(userInfo != null && !userInfo.isEmpty()) {
                String userId= "";

                    for (int i = 0; i < labels.length; i ++) {
                        fields[i] = new JTextField();
                        try {
                            if (i == 0) {
                                Iterator itr = userInfo.entrySet().iterator();
                                while (itr.hasNext()) {
                                    Map.Entry pair = (Map.Entry) itr.next();
                                    if (labels[i].equals("User Id")) {
                                        userId = (String) pair.getKey();
                                        fields[i].setColumns(widths[i]);
                                        fields[i].setText(userId);
                                        fields[i].setEnabled(false);
                                    }
                                }
                            }


                            if (i < widths.length) {
                                fields[i].setColumns(widths[i]);
                                if (labels[i].equals("First Name")) {
                                    fields[i].setText(userInfo.get(userId).getFirstName());
                                } else if (labels[i].equals("Last Name")) {
                                    fields[i].setText(userInfo.get(userId).getLastName());
                                }
                            }
                        }catch (Exception mue) {
                            throw new ManageUserException("Exception ocuured.");
                        }

                        JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
                        lab.setLabelFor(fields[i]);

                        labelPanel.add(lab);
                        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        p.add(fields[i]);
                        fieldPanel.add(p);
                    }
        }
    }


    private FormPage(String[] labels, int[] widths, boolean isViewOnly, List<Map<String, UserInfo>> userInfoList) throws ManageUserException {
        super(new BorderLayout());

        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        fields = new JTextField[labels.length];

        if(isViewOnly && userInfoList != null) {
            if(userInfoList.size() > 0) {
                String userId= "";
                for(Map<String,UserInfo> userInfo : userInfoList) {

                    for (int i = 0; i < labels.length; i ++) {
                        fields[i] = new JTextField();

                        if(i == 0){
                            try {
                                Iterator itr = userInfo.entrySet().iterator();
                                while (itr.hasNext()) {
                                    Map.Entry pair = (Map.Entry) itr.next();
                                    if (labels[i].equals("User Id")) {
                                        userId = (String) pair.getKey();
                                        fields[i].setColumns(widths[i]);
                                        fields[i].setText(userId);
                                    }
                                }
                            } catch (Exception e) {
                                throw new ManageUserException("Exception occured while iterating over userinfo map.");
                            }
                        }


                        if (i < widths.length) {
                            fields[i].setColumns(widths[i]);
                            if(labels[i].equals("First Name")) {
                                fields[i].setText(userInfo.get(userId).getFirstName());
                            } else if(labels[i].equals("Last Name")) {
                                fields[i].setText(userInfo.get(userId).getLastName());
                            }
                        }
                        JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
                        lab.setLabelFor(fields[i]);

                        labelPanel.add(lab);
                        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        p.add(fields[i]);
                        fieldPanel.add(p);
                    }
                }
            }
        } else {

            for (int i = 0; i < labels.length; i++) {
                if(i > 0) {
                    fields[i] = new JTextField();
                    if (i < widths.length)
                        fields[i].setColumns(widths[i]);
                    JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
                    lab.setLabelFor(fields[i]);

                    labelPanel.add(lab);
                    JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    p.add(fields[i]);
                    fieldPanel.add(p);
                }
            }
        }
    }


    protected void createForm(String[] labels, int[] widths, List<Map<String, UserInfo>> userInfos) throws ManageUserException{
        final FormPage form = new FormPage(labels, widths, false, null);
        JButton submit = new JButton("Add");

        JFrame f = new JFrame("Add  User");
        f.setSize(100, 100);
        f.getContentPane().add(form, BorderLayout.CENTER);
        JPanel p = new JPanel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userId = UUID.randomUUID().toString().substring(0,8);
                UserInfo userInfo = new UserInfo();
                userInfo.setFirstName(form.getText(1));
                userInfo.setLastName(form.getText(2));
                userInfo.setUserId(userId);

                Map<String, UserInfo> infoMap = new HashMap<>();
                infoMap.put(userId, userInfo);
                userInfos.add(infoMap);
                JOptionPane.showMessageDialog(null, "User added successfully.");
                f.setVisible(false);
            }
        });

        p.add(submit);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    protected void viewForm(List<Map<String, UserInfo>> userInfos) throws ManageUserException {
        final FormPage form = new FormPage(labels, widths, true, userInfos);
        JFrame f = new JFrame("View  User");
        JButton ok = new JButton("Ok");
        f.setSize(100, 100);
        f.getContentPane().add(form, BorderLayout.CENTER);
        JPanel p = new JPanel();

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });

        p.add(ok);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    protected void searchAndUpdateForm(List<Map<String, UserInfo>> userInfos) throws ManageUserException {
        SearchUserPage searchUserPage = new SearchUserPage();
        Map<String, UserInfo> userInfoMap = new HashMap<>();
        searchUserPage.searchUser(userInfos, userInfoMap);
    }


    protected String getText(int i) {
        return (fields[i].getText());
    }


}
