package com.abani.example.android.dummyprofilepage.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abani.example.android.dummyprofilepage.R;

/**
 * Created by user on 3/16/2018.
 */

public class NotificationTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.notification_tab, container, false);
    }
}
