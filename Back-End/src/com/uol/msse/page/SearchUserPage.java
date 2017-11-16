package com.uol.msse.page;


import com.uol.msse.data.UserInfo;
import com.uol.msse.exception.ManageUserException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchUserPage extends JPanel {

    protected JTextField[] fields;
    protected String[] labels = {"User Id"};
    protected int[] widths = {15};

    protected String[] formPageLabels = {"User Id", "First Name", "Last Name"};
    protected int[] formPageWidths = {15, 15, 15};


    public SearchUserPage() {
    }

    private SearchUserPage(String[] labels, int[] widths) {
        super(new BorderLayout());

        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        add(labelPanel, BorderLayout.WEST);
        add(fieldPanel, BorderLayout.CENTER);
        fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
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

    public void searchUser(List<Map<String, UserInfo>> userInfos, Map<String, UserInfo> userInfoMap) throws ManageUserException {

        UserInfo userInfoObject = new UserInfo();

        final SearchUserPage form = new SearchUserPage(labels, widths);
        JButton submit = new JButton("Search");

        JFrame f = new JFrame("Search  User");
        f.setSize(100, 100);
        f.getContentPane().add(form, BorderLayout.CENTER);
        JPanel p = new JPanel();

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (form.getText(0).length() <= 0) {
                    JOptionPane.showMessageDialog(null, "User Id is required.");
                }
                for (Map<String, UserInfo> userInfo : userInfos) {
                    Iterator itr = userInfo.entrySet().iterator();
                    while (itr.hasNext()) {
                        Map.Entry pair = (Map.Entry) itr.next();
                        String userId = (String) pair.getKey();
                        if (userId.equals(form.getText(0))) {
                            UserInfo savedUserInfo = (UserInfo) pair.getValue();
                            userInfoObject.setFirstName(savedUserInfo.getFirstName());
                            userInfoObject.setLastName(savedUserInfo.getLastName());
                            userInfoMap.put(userId, userInfoObject);
                        }
                    }
                }

                f.setVisible(false);
                try {
                    FormPage form = new FormPage(formPageLabels, formPageWidths, userInfoMap);

                    JFrame f1 = new JFrame("Update  User");
                    JButton ok = new JButton("Update");
                    f1.setSize(100, 100);
                    f1.getContentPane().add(form, BorderLayout.CENTER);
                    JPanel p1 = new JPanel();

                    ok.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // update list
                            for (Map<String, UserInfo> userInfo : userInfos) {
                                Iterator itr = userInfo.entrySet().iterator();
                                while (itr.hasNext()) {
                                    Map.Entry pair = (Map.Entry) itr.next();
                                    String userId = (String) pair.getKey();
                                    if (userId.equals(form.getText(0))) {
                                        UserInfo updatedUserInfo = new UserInfo();
                                        updatedUserInfo.setUserId(userId);
                                        updatedUserInfo.setFirstName(form.getText(1));
                                        updatedUserInfo.setLastName(form.getText(2));

                                        pair.setValue(updatedUserInfo);
                                    }
                                }
                            }

                            JOptionPane.showMessageDialog(null, "User updated successfully.");
                            f1.setVisible(false);
                        }
                    });

                    p1.add(ok);
                    f1.getContentPane().add(p1, BorderLayout.SOUTH);
                    f1.pack();
                    f1.setVisible(true);
                } catch (ManageUserException mue) {
                    System.out.println(mue.getMessage());
                }
            }

        });

        p.add(submit);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    private String getText(int i) {
        return (fields[i].getText());
    }
}
