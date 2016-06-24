package com.example.darkwh.mvp_project.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.base.ToolBarActivity;
import com.example.darkwh.mvp_project.component.AppComponent;
import com.example.darkwh.mvp_project.main.android.AndroidFragment;
import com.example.darkwh.mvp_project.main.exresources.ExResourcesFragment;
import com.example.darkwh.mvp_project.main.home.HomeFragment;
import com.example.darkwh.mvp_project.main.ios.IosFragment;
import com.example.darkwh.mvp_project.main.recommend.RecommendFragment;
import com.example.darkwh.mvp_project.main.restvideo.RestVideoFragment;
import com.example.darkwh.mvp_project.main.webfont.WebFontFragment;
import com.example.darkwh.mvp_project.widget.MyTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ToolBarActivity implements View.OnClickListener {

    @BindView(R.id.title_bar)
    MyTitleBar titleBar;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.ll_welfare)
    LinearLayout llWelfare;
    @BindView(R.id.ll_android)
    LinearLayout llAndroid;
    @BindView(R.id.ll_ios)
    LinearLayout llIos;
    @BindView(R.id.ll_front)
    LinearLayout llFront;
    @BindView(R.id.ll_exresources)
    LinearLayout llExresources;
    @BindView(R.id.ll_rest_video)
    LinearLayout llRestVideo;
    @BindViews({R.id.ll_welfare, R.id.ll_android, R.id.ll_ios, R.id.ll_front, R.id.ll_exresources, R.id.ll_rest_video,R.id.ll_recommend,R.id.ll_app})
    List<LinearLayout> tab_list;

    private List<Fragment> fragment_list = new ArrayList<>();
    private HomeFragment homeFragment;
    private AndroidFragment androidFragment;
    private IosFragment iosFragment;
    private WebFontFragment webFontFragment;
    private ExResourcesFragment exResourcesFragment;
    private RestVideoFragment restVideoFragment;
    private RecommendFragment recommendFragment;
    private AppComponent appComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initInject();
        setTitleBar(titleBar);
        initViews();
    }

    @Override
    protected void configTitleBar() {
        setTextTitle(R.string.app_title);
        setCustomNavigationIcon(v -> drawerlayout.openDrawer(Gravity.LEFT));
    }

    private void initInject() {
    }

    private void initViews() {
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        llWelfare.setSelected(true);
        showModule(llWelfare);
    }

    @OnClick({R.id.ll_welfare, R.id.ll_android, R.id.ll_ios, R.id.ll_front, R.id.ll_exresources, R.id.ll_rest_video,R.id.ll_recommend,R.id.ll_app})
    public void onClick(View view) {
        tabClickEvent(view);
        drawerlayout.closeDrawer(Gravity.LEFT);
    }

    private void tabClickEvent(View view) {
        if (!view.isSelected()) {
            clearAllSelected();
            view.setSelected(true);
            showModule(view);
        }
    }

    /**
     * 清除导航栏的选中状态
     */
    private void clearAllSelected() {
        for (LinearLayout val : tab_list) {
            val.setSelected(false);
        }
    }

    /**
     * 显示模块
     */
    private void showModule(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (view.getId()) {
            case R.id.ll_welfare:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragment_list.add(homeFragment);
                    fragmentTransaction.add(R.id.framelayout, homeFragment);
                }
                else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.ll_android:
                if (androidFragment == null) {
                    androidFragment = new AndroidFragment();
                    fragment_list.add(androidFragment);
                    fragmentTransaction.add(R.id.framelayout, androidFragment);
                }
                else {
                    fragmentTransaction.show(androidFragment);
                }
                break;
            case R.id.ll_ios:
                if (iosFragment == null) {
                    iosFragment = new IosFragment();
                    fragment_list.add(iosFragment);
                    fragmentTransaction.add(R.id.framelayout, iosFragment);
                }
                else {
                    fragmentTransaction.show(iosFragment);
                }
                break;
            case R.id.ll_front:
                if (webFontFragment == null) {
                    webFontFragment = new WebFontFragment();
                    fragment_list.add(webFontFragment);
                    fragmentTransaction.add(R.id.framelayout, webFontFragment);
                }
                else {
                    fragmentTransaction.show(webFontFragment);
                }
                break;
            case R.id.ll_exresources:
                if (exResourcesFragment == null) {
                    exResourcesFragment = new ExResourcesFragment();
                    fragment_list.add(exResourcesFragment);
                    fragmentTransaction.add(R.id.framelayout, exResourcesFragment);
                }
                else {
                    fragmentTransaction.show(exResourcesFragment);
                }
                break;
            case R.id.ll_rest_video:
                if (restVideoFragment == null) {
                    restVideoFragment = new RestVideoFragment();
                    fragment_list.add(restVideoFragment);
                    fragmentTransaction.add(R.id.framelayout, restVideoFragment);
                }
                else {
                    fragmentTransaction.show(restVideoFragment);
                }
                break;
            case R.id.ll_recommend:
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                    fragment_list.add(recommendFragment);
                    fragmentTransaction.add(R.id.framelayout, recommendFragment);
                }
                else {
                    fragmentTransaction.show(recommendFragment);
                }
                break;
            case R.id.ll_app:
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     * 隐藏所有Fragment
     */
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        for (Fragment val : fragment_list) {
            fragmentTransaction.hide(val);
        }
    }

}
