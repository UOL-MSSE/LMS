package com.uol.msse.page;


import com.uol.msse.data.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormPage extends JPanel {

    protected JTextField[] fields;
    protected String[] labels = { "First Name", "Last Name"};
    protected int[] widths = { 15, 15 };


    public FormPage(){
    }

    private FormPage(String[] labels, int[] widths, boolean isViewOnly, List<UserInfo> userInfoList) {
        super(new BorderLayout());

        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        fields = new JTextField[labels.length];

        if(isViewOnly && userInfoList != null) {
            if(userInfoList.size() > 0) {
                for(UserInfo userInfo : userInfoList) {
                    for (int i = 0; i < labels.length; i += 1) {
                        fields[i] = new JTextField();
                        if (i < widths.length) {
                            fields[i].setColumns(widths[i]);
                            if(labels[i].equals("First Name")) {
                                fields[i].setText(userInfo.getFirstName());
                            } else if(labels[i].equals("Last Name")) {
                                fields[i].setText(userInfo.getLastName());
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

            for (int i = 0; i < labels.length; i += 1) {
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


    protected void createForm(String[] labels, int[] widths, List<UserInfo> userInfos) {
        final FormPage form = new FormPage(labels, widths, false, null);
        JButton submit = new JButton("Add");

        JFrame f = new JFrame("Add  User");
        f.setSize(100, 100);
        f.getContentPane().add(form, BorderLayout.CENTER);
        JPanel p = new JPanel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserInfo userInfo = new UserInfo();
                userInfo.setFirstName(form.getText(0));
                userInfo.setLastName(form.getText(1));

                userInfos.add(userInfo);
                JOptionPane.showMessageDialog(null, "User added successfully.");
                f.setVisible(false);
            }
        });

        p.add(submit);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    protected void viewForm(List<UserInfo> userInfos) {
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


    protected String getText(int i) {
        return (fields[i].getText());
    }


}
