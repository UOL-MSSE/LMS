package com.uol.msse.page;


import com.uol.msse.data.UserInfo;
import com.uol.msse.exception.ManageUserException;

import java.util.List;
import java.util.Map;

public class ViewUserPage extends FormPage {

    public ViewUserPage(List<Map<String, UserInfo>> userInfos) {
        try {
            viewForm(userInfos);
        } catch (ManageUserException mue) {
            System.out.println(mue.getMessage());
        }
    }

}
