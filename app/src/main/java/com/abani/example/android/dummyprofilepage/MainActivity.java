package com.abani.example.android.dummyprofilepage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.abani.example.android.dummyprofilepage.adapter.MyPagerAdapter;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] icons = {R.drawable.ic_more_horiz_black_24dp, R.drawable.ic_mail_outline_black_24dp};
    private ImageView[] images;
    private int selectedTabPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ImageView[3];
        images[0] = findViewById(R.id.image_one);
        images[1] = findViewById(R.id.image_two);
        images[2] = findViewById(R.id.image_three);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this,R.color.secondaryColor));
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);

        createAllTabs();

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        setUpTitles();


        tabLayout.addOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    private void createAllTabs() {
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
    }

    private void setUpTitles() {
        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setText("Profile");
        tabLayout.getTabAt(2).setIcon(icons[1]);
        tabLayout.setTabTextColors(ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.white)));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        setCurrentTab(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setCurrentTab(int position){

        viewPager.setCurrentItem(position);

        images[selectedTabPosition].setImageResource(R.drawable.default_dot);

        selectedTabPosition = position;

        images[position].setImageResource(R.drawable.selected_dot);
    }
}
