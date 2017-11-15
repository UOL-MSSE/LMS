package com.uol.msse.page;


import com.uol.msse.data.UserInfo;

import java.util.List;

public class ViewUserPage extends FormPage {

    public ViewUserPage(List<UserInfo> userInfos) {
        viewForm(userInfos);
    }

}
