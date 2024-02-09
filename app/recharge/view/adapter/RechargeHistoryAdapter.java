package com.livpure.safedrink.app.recharge.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.app.recharge.model.RechargeDetailsItem;
import java.util.List;
/* loaded from: classes3.dex */
public class RechargeHistoryAdapter extends BaseAdapter {
    List<RechargeDetailsItem> dataModelArrayList;
    private final LayoutInflater layoutInflater;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public RechargeHistoryAdapter(Context context, List<RechargeDetailsItem> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataModelArrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.dataModelArrayList.get(position);
    }

    /* loaded from: classes3.dex */
    private static class ViewHolder {
        TextView amount;
        TextView date;
        TextView status;

        private ViewHolder(View view) {
            this.date = (TextView) view.findViewById(R.id.date);
            this.amount = (TextView) view.findViewById(R.id.amount);
            this.status = (TextView) view.findViewById(R.id.status);
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        RechargeDetailsItem rechargeDetailsItem = this.dataModelArrayList.get(position);
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_item, (ViewGroup) null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.date.setText(rechargeDetailsItem.getRechargeDate());
        viewHolder.amount.setText(rechargeDetailsItem.getRechargeAmount());
        viewHolder.status.setText(rechargeDetailsItem.getRechargeStatus());
        return convertView;
    }
}
