package com.example.formget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by vikram on 8/2/17.
 */

public class DataListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Data>mDataList;

    public DataListAdapter(Context mContext, List<Data> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.data_item_list, null);
        TextView name=(TextView)v.findViewById(R.id.name);
        TextView college=(TextView)v.findViewById(R.id.college);
        TextView number=(TextView)v.findViewById(R.id.number);

        name.setText(mDataList.get(position).getName());
        college.setText(mDataList.get(position).getCollege());
        number.setText(mDataList.get(position).getNumber());

        v.setTag(mDataList.get(position));

        return v;
    }
}
