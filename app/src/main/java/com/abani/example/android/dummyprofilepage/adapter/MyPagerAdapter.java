package com.abani.example.android.dummyprofilepage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.abani.example.android.dummyprofilepage.tabs.MenuTab;
import com.abani.example.android.dummyprofilepage.tabs.NotificationTab;
import com.abani.example.android.dummyprofilepage.tabs.ProfileTab;

/**
 * Created by user on 3/16/2018.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {


    int tabCount;


    public MyPagerAdapter(FragmentManager manager, int tabCount) {
        super(manager);
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                MenuTab menuTab = new MenuTab();
                return menuTab;
            case 1:
                ProfileTab profileTab = new ProfileTab();
                return profileTab;
            case 2:
                NotificationTab nTab = new NotificationTab();
                return nTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
