package com.example.darkwh.mvp_project.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.darkwh.mvp_project.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerviewActivity extends Activity {

    @BindView(R.id.recyckerView)
    RecyclerView recyckerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews(){
        recyckerView.setLayoutManager(new LinearLayoutManager(this));
        recyckerView.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends RecyclerView.Adapter<SimpleItemViewHolder>{

        @Override
        public int getItemCount() {
            return 50;
        }

        @Override
        public SimpleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent,false);
            return new SimpleItemViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SimpleItemViewHolder holder, int position) {
            holder.textView.setText(position+"");
        }

    }

    protected final static class SimpleItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView;

        public SimpleItemViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

}
