package com.enlern.pen.sms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enlern.pen.sms.R;
import com.enlern.pen.sms.bean.NodeSave;
import com.xiandon.wsn.node.NodeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pen on 2017/9/14.
 */

public class MainHistoryAdapter extends RecyclerView.Adapter {
    private static final String TAG = "MainHistoryAdapter";
    private Context mContext;
    private List<NodeSave> nodeInfos = new ArrayList<>();
    private LayoutInflater layoutInflater;


    public MainHistoryAdapter(Context context, List<NodeSave> nodeInfos) {
        this.mContext = context;
        this.nodeInfos = nodeInfos;
        layoutInflater = LayoutInflater.from(context);
    }


    public void addData(int count, NodeSave nodeSave) {
        nodeInfos.add(count, nodeSave);
        notifyItemInserted(count);
        notifyDataSetChanged();

        if (nodeInfos.size() > 100) {
            clearData();
        }
    }

    public void clearData() {
        nodeInfos.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_history_item, parent, false);
        RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(view) {
        };
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        TextView tv_his_id = holder.itemView.findViewById(R.id.tv_his_id);
        TextView tv_his_type = holder.itemView.findViewById(R.id.tv_his_type);
        TextView tv_his_cn_name = holder.itemView.findViewById(R.id.tv_his_cn_name);
        TextView tv_his_data = holder.itemView.findViewById(R.id.tv_his_data);
        TextView tv_his_data_sys = holder.itemView.findViewById(R.id.tv_his_data_sys);
        TextView tv_his_time = holder.itemView.findViewById(R.id.tv_his_time);

        tv_his_id.setText(nodeInfos.get(position).getId() + "");
        tv_his_type.setText(nodeInfos.get(position).getN_sensor_number());
        tv_his_cn_name.setText(nodeInfos.get(position).getN_sensor_cn_name());
        tv_his_data.setText(nodeInfos.get(position).getN_data_buffer());
        tv_his_data_sys.setText(nodeInfos.get(position).getN_data());
        tv_his_time.setText(nodeInfos.get(position).getN_insert_time());


    }

    @Override
    public int getItemCount() {
        return nodeInfos.size();
    }


}
