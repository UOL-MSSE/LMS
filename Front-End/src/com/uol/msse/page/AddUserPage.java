package com.uol.msse.page;


import com.uol.msse.data.UserInfo;

import java.util.List;

public class AddUserPage extends FormPage {

    public AddUserPage(List<UserInfo> userInfos) {
        createForm(labels, widths, userInfos);
    }

}
