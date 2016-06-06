package com.example.darkwh.mvp_project.main.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.darkwh.mvp_project.R;
import com.example.darkwh.mvp_project.common.base.ToolBarActivity;
import com.example.darkwh.mvp_project.common.widget.MyTitleBar;
import com.example.darkwh.mvp_project.main.holder.BannerHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ToolBarActivity {


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
        setTitleBar(titleBar);
        initViews();
    }

    @Override
    protected void configTitleBar() {
        setTextTitle(R.string.app_title);
        setCustomNavigationIcon(v -> drawerlayout.openDrawer(Gravity.LEFT));
    }

    private void initViews() {
        List<Integer> viewList = new ArrayList<>();
        viewList.add(R.mipmap.banner1);
        viewList.add(R.mipmap.banner1);
        viewList.add(R.mipmap.banner1);
        viewList.add(R.mipmap.banner1);
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
}
