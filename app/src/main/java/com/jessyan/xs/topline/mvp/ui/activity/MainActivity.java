package com.jessyan.xs.topline.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.jessyan.xs.topline.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * app主界面
 */
public class MainActivity extends AppCompatActivity {


    @BindView(R.id.nav_tv)
    TextView mNavTv;
    @BindView(R.id.bottom_nav)
    BottomNavigationView mBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNavTv.setText(R.string.nav_read);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_ui:
                        mNavTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_data:
                        mNavTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_service:
                        mNavTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_net:
                        mNavTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_media:
                        mNavTv.setText(item.getTitle());
                        break;
                }
                return true;
            }
        });

    }


}
