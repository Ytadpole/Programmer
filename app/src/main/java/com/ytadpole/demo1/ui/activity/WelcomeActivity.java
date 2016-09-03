package com.ytadpole.demo1.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ytadpole.demo1.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.indicator)
    LinearLayout indicator;
    private List<View> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        initViewPager();
        initIndicator();
    }

    private void initIndicator() {
//        ImageView[] ind = new ImageView[4];
//        for(int i =0; i < ind.length; i++){
//
//        }
    }

    private void initViewPager() {
        final int[] images;
        images = new int[]{R.drawable.tutorial_1, R.drawable.tutorial_2, R.drawable.tutorial_3, R.drawable.tutorial_4};
        for (int i = 0; i < images.length; i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.item_welcome, null);
            ImageView img = (ImageView) v.findViewById(R.id.img);
            Button btn = (Button)v.findViewById(R.id.getin);
            if(i == images.length -1){
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                        finish();
                    }
                });
            }
            img.setBackgroundResource(images[i]);
            list.add(v);
        }
        mViewpager.setAdapter(new PagerAdapter() {


            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager) container).removeView(list.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(list.get(position));
                return list.get(position);
            }
        });
    }


}
