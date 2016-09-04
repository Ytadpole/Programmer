package com.ytadpole.demo1.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ytadpole.demo1.R;
import com.ytadpole.demo1.ui.fragment.DynamicFragment;
import com.ytadpole.demo1.ui.fragment.FavorFragment;
import com.ytadpole.demo1.ui.fragment.HomeFragment;
import com.ytadpole.demo1.ui.fragment.MyFragment;
import com.ytadpole.demo1.ui.fragment.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.menu)
    RadioGroup menu;
    private Fragment[] mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mFManager = getSupportFragmentManager();
        initViewPager();
        initClick();

    }

    private void initClick() {
        menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.menu_favor:
                       viewPager.setCurrentItem(0);
                        ((RadioButton)menu.getChildAt(0)).setChecked(true);break;
                    case R.id.menu_dynamic:
                        viewPager.setCurrentItem(1);
                        ((RadioButton)menu.getChildAt(1)).setChecked(true);break;
                    case R.id.menu_search:viewPager.setCurrentItem(2);
                        ((RadioButton)menu.getChildAt(2)).setChecked(true);break;
                    case R.id.menu_my:viewPager.setCurrentItem(3);
                        ((RadioButton)menu.getChildAt(3)).setChecked(true);break;
                }
            }
        });
    }

    private void initViewPager() {
        mFragments = new Fragment[]{new HomeFragment(), new DynamicFragment(), new SearchFragment(), new MyFragment()};
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

            @Override
            public int getCount() {
                return mFragments.length;
            }
        });
        viewPager.setCurrentItem(0);
        ((RadioButton)menu.getChildAt(0)).setChecked(true);
    }
}
