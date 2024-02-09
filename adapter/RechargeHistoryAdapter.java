package com.livpure.safedrink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.livpure.safedrink.R;
import com.livpure.safedrink.model.DataModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class RechargeHistoryAdapter extends BaseAdapter {
    private final ArrayList<DataModel> dataModelArrayList;
    private final LayoutInflater layoutInflater;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public RechargeHistoryAdapter(Context context, ArrayList<DataModel> dataModelArrayList) {
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
        DataModel dataModel = this.dataModelArrayList.get(position);
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(R.layout.row_item, (ViewGroup) null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.date.setText(dataModel.getRechargeDate());
        viewHolder.amount.setText(dataModel.getRechargeAmount());
        viewHolder.status.setText(dataModel.getRechargeStatus());
        return convertView;
    }
}
