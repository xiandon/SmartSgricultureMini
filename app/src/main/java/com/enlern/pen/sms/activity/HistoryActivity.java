package com.enlern.pen.sms.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.enlern.pen.sms.MainActivity;
import com.enlern.pen.sms.R;
import com.enlern.pen.sms.adapter.MainHistoryAdapter;
import com.enlern.pen.sms.adapter.MainRecAdapter;
import com.enlern.pen.sms.bean.NodeSave;
import com.enlern.pen.sms.greendao.NodeSaveDao;
import com.enlern.pen.sms.greendao.node_save.NodeSaveUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pen on 2018/3/5.
 */

public class HistoryActivity extends BaseActivity {

    private Context context;
    private MainHistoryAdapter adapter;
    private NodeSaveDao nodeSaveDao;
    private String TAG = "HistoryActivity";

    @BindView(R.id.tv_public_title)
    TextView tvPublicTitle;
    @BindView(R.id.tv_title_setting)
    TextView tvTitleSetting;
    @BindView(R.id.tv_title_clean)
    TextView tvTitleClean;
    @BindView(R.id.recyclerView_node_history)
    RecyclerView recyclerViewNodeHistory;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_history);
        ButterKnife.bind(this);
        context = HistoryActivity.this;
        initViews();
    }

    private void initViews() {

        tvTitleSetting.setVisibility(View.GONE);
        tvTitleClean.setVisibility(View.GONE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(HistoryActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewNodeHistory.setLayoutManager(layoutManager);

        List<NodeSave> nodeSaves = new ArrayList<>();
        nodeSaveDao = NodeSaveUtils.getSingleTon().getmDaoSession().getNodeSaveDao();

        Intent intent = getIntent();
        String node_key = intent.getStringExtra("NODE_KEY");
        nodeSaves = nodeSaveDao.loadAll();
        if (node_key.equals("0000")) {
            tvPublicTitle.setText("全部历史记录");
            adapter = new MainHistoryAdapter(context, nodeSaves);
        } else {
            tvPublicTitle.setText("单节点历史记录");
            List<NodeSave> nodeSaves2 = new ArrayList<>();
            for (NodeSave nodeSave : nodeSaves) {
                if (nodeSave.getN_sensor_number().equals(node_key)) {
                    nodeSaves2.add(nodeSave);
                }
                adapter = new MainHistoryAdapter(context, nodeSaves2);
            }
        }
        recyclerViewNodeHistory.setAdapter(adapter);
    }
}
