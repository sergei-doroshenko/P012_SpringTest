package org.sergei.quest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Created by sergei on 1/20/16.
 */
public class MenuItem {
    private List<MenuItem> children;
    private String id;
    private String title;
    private MenuItemListener listener;

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setListener(MenuItemListener listener) {
        this.listener = listener;
    }

    public JMenuItem build() {
        if (null == children) {
            JMenuItem menuItem = new JMenuItem(title);
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (null != listener) {
                        listener.itemSelected(id);
                    }
                }
            });
            return menuItem;
        } else {
            JMenu menu = new JMenu(title);
            for (MenuItem child: children) {
                menu.add(child.build());
            }
            return menu;
        }
    }
}
