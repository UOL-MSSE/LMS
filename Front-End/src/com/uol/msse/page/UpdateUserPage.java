package com.uol.msse.page;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class UpdateUserPage extends AbstractAction {

    private DefaultListModel model;

    public UpdateUserPage(DefaultListModel model){
        this.model = model;
        JList jList = new JList(model);
        jList.setBorder(BorderFactory.createEtchedBorder());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!model.isEmpty()) {
            model.clear();
        }

        if (e.getID() == ActionEvent.ACTION_PERFORMED) {
            model.addElement("Event Id: ACTION_PERFORMED");
        }

    }
}
