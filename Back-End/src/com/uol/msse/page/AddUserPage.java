package com.uol.msse.page;


import com.uol.msse.data.UserInfo;
import com.uol.msse.exception.ManageUserException;

import java.util.List;
import java.util.Map;

/**
 * UI Page to display form for adding user.
 * This extends FormPage which inturn extends JPanel
 *
 */
public class AddUserPage extends FormPage {

    /**
     * Constructor passing the List that holds user data
     * @param userInfos
     */
    public AddUserPage(List<Map<String,UserInfo>> userInfos) {
        try {
            createForm(labels, widths, userInfos);
        } catch( ManageUserException mue) {
            System.out.println(mue.getMessage());
        }
    }

}
