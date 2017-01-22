package com.jessyan.xs.topline.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jessyan.xs.topline.R;
import com.jessyan.xs.topline.mvp.ui.fragment.FindFragment;
import com.jessyan.xs.topline.mvp.ui.fragment.MeFragment;
import com.jessyan.xs.topline.mvp.ui.fragment.MsgFragment;
import com.jessyan.xs.topline.mvp.ui.fragment.ReadFragment;
import com.jessyan.xs.topline.mvp.ui.fragment.ShareFragment;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * app主界面
 */
public class MainActivity extends RxAppCompatActivity  implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.sub_content)
    FrameLayout mSubContent;
    @BindView(R.id.rb_read)
    RadioButton mRbRead;
    @BindView(R.id.rb_msg)
    RadioButton mRbMsg;
    @BindView(R.id.rb_add)
    RadioButton mRbAdd;
    @BindView(R.id.rb_find)
    RadioButton mRbFind;
    @BindView(R.id.rb_me)
    RadioButton mRbMe;
    @BindView(R.id.radio_group)
    RadioGroup mRadioGroup;

    //fragment标记
    private String FRAGMENT_TAG_READ = "ReadFragment";
    private String FRAGMENT_TAG_MSG = "MsgFragment";
    private String FRAGMENT_TAG_SHARE = "ShareFragment";
    private String FRAGMENT_TAG_FIND = "FindFragment";
    private String FRAGMENT_TAG_ME = "MeFragment";

    private ReadFragment mReadFragment;
    private MsgFragment mMsgFragment;
    private ShareFragment mShareFragment;
    private FindFragment mFindFragment;
    private MeFragment mMeFragment;


    @Override
    public void onStart() {
        setDefaultFragment();//写在onCreateView里面，当页面跑到其他Fragment再回来就不会生效
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        if (savedInstanceState != null) {
            mReadFragment = (ReadFragment) getSupportFragmentManager().findFragmentByTag(ReadFragment.class.getName());
            mMsgFragment = (MsgFragment) getSupportFragmentManager().findFragmentByTag(MsgFragment.class.getName());
            mShareFragment = (ShareFragment) getSupportFragmentManager().findFragmentByTag(ShareFragment.class.getName());
            mFindFragment = (FindFragment) getSupportFragmentManager().findFragmentByTag(FindFragment.class.getName());
            mMeFragment = (MeFragment) getSupportFragmentManager().findFragmentByTag(FindFragment.class.getName());
        } else {
            mReadFragment = ReadFragment.newInstance("阅读");
            mMsgFragment=MsgFragment.newInstance("消息");
            mShareFragment=ShareFragment.newInstance("分享");
            mFindFragment=FindFragment.newInstance("发现");
            mMeFragment=MeFragment.newInstance("我的");
        }

    }

    private void setDefaultFragment() {
        mRbRead.setChecked(true);
        mRbMsg.setChecked(false);
        mRbAdd.setChecked(false);
        mRbFind.setChecked(false);
        mRbMe.setChecked(false);
        if (mRbRead.isChecked()) {
            setTabState();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mReadFragment = mReadFragment.newInstance("阅读");
            transaction.replace(R.id.sub_content, mReadFragment).commit();
        }
    }


    private void setTabState() {
        setReadState();
        setMsgState();
        setShareState();
        setMeState();

    }


    /**
     * set tab  state
     */
    private void setReadState() {
        if (mRbRead.isChecked()) {
            mRbRead.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRbRead.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setMsgState() {
        if (mRbMsg.isChecked()) {
            mRbMsg.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRbMsg.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setShareState() {
        if (mRbAdd.isChecked()) {
            mRbAdd.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRbAdd.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setFindState() {
        if (mRbFind.isChecked()) {
            mRbFind.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRbFind.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setMeState() {
        if (mRbMe.isChecked()) {
            mRbMe.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRbMe.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }





    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (checkedId) {
            case R.id.rb_read:
                if (mReadFragment == null) {
                    mReadFragment = ReadFragment.newInstance(getString(R.string.nav_read));
                }
                transaction.replace(R.id.sub_content, mReadFragment);
                break;
            case R.id.rb_msg:
                if (mMsgFragment == null) {
                    mMsgFragment = MsgFragment.newInstance(getString(R.string.nav_msg));
                }
                transaction.replace(R.id.sub_content, mMsgFragment);
                break;
            case R.id.rb_add:
                if (mShareFragment == null) {
                    mShareFragment = ShareFragment.newInstance(getString(R.string.nav_add));
                }
                transaction.replace(R.id.sub_content, mShareFragment);
                break;
            case R.id.rb_find:
                if (mFindFragment == null) {
                    mFindFragment = FindFragment.newInstance(getString(R.string.nav_find));
                }
                transaction.replace(R.id.sub_content, mFindFragment);
                break;
            case R.id.rb_me:
                if (mMeFragment == null) {
                    mMeFragment = MeFragment.newInstance(getString(R.string.nav_me));
                }
                transaction.replace(R.id.sub_content, mMeFragment);
                break;
        }
        setTabState();
        transaction.commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
}
