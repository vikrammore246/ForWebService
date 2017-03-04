package com.example.formget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewForm extends AppCompatActivity {

    private ListView dvList;
    private DataListAdapter adapter;
    private List<Data> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_form);

        dvList=(ListView)findViewById(R.id.dataList);
        mDataList = new ArrayList<>();
    }
}
