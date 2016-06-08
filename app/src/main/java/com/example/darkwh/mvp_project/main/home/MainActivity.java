package com.example.darkwh.mvp_project.main.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.base.ToolBarActivity;
import com.example.darkwh.mvp_project.component.DaggerHomeComponent;
import com.example.darkwh.mvp_project.component.HomeComponent;
import com.example.darkwh.mvp_project.holders.BannerHolder;
import com.example.darkwh.mvp_project.module.HomeModule;
import com.example.darkwh.mvp_project.widget.MyTitleBar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ToolBarActivity implements HomeContract.View {

    HomeComponent testComponent;
    @Inject
    HomeContract.Presenter presenter;
    @Inject
    Context context;

    @BindView(R.id.title_bar)
    MyTitleBar titleBar;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initInject();
        setTitleBar(titleBar);
        initViews();
        presenter.test();
    }

    @Override
    protected void configTitleBar() {
        setTextTitle(R.string.app_title);
        setCustomNavigationIcon(v -> drawerlayout.openDrawer(Gravity.LEFT));
    }

    private void initInject(){
        testComponent = DaggerHomeComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .homeModule(new HomeModule(this))
                .build();
        testComponent.inject(this);
    }

    private void initViews() {
        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        List<Integer> viewList = new ArrayList<>();
        viewList.add(R.mipmap.banner1);
        viewList.add(R.mipmap.banner2);
        viewList.add(R.mipmap.banner3);
        viewList.add(R.mipmap.banner4);
        viewList.add(R.mipmap.banner5);
        viewList.add(R.mipmap.banner6);
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        convenientBanner.setPages(() -> new BannerHolder(), viewList)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_save, R.mipmap.ic_reorder})
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getBaseContext(),position+"",Toast.LENGTH_SHORT).show();
                    }
                })
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        convenientBanner.startTurning(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }

    @Override
    public void setBanner() {

    }

    @Override
    public void setRecommend() {

    }

    @Override
    public void test() {
        Toast.makeText(getBaseContext(),"测试一下",Toast.LENGTH_SHORT).show();
    }


}
