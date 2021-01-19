package com.go_m.demolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Adapter_calender_item> listensData = new ArrayList<Adapter_calender_item>();
    MyCustomAdapter manatee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(R.id.ListView_mainLayout);


        //add data and view it
        listensData.add
                (new Adapter_calender_item("Data Science ", "Sun", 27, "Feb"));
        listensData.
                add(new Adapter_calender_item("Machine Learning ", "Sun", 27, "Feb"));
        listensData.
                add(new Adapter_calender_item("Introduction to Flutter", "Mon", 4, "Mar"));
        listensData.
                add(new Adapter_calender_item("Machine Learning ", "Wen", 6, "Mar"));
        listensData.
                add(new Adapter_calender_item("Data Talk 00 ", "Sat", 9, "Mar"));

        manatee = new MyCustomAdapter(listensData);
        listView.setAdapter(manatee);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final Adapter_calender_item adapterView = listensData.get(position);
                TextView eventName = (TextView) view.findViewById(R.id.EventName);
                Toast.makeText(getApplicationContext(), "You Selected " + eventName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void Adding_new_MedicineItem(View view) {
        listensData.add(new Adapter_calender_item("New Event addeed", "Tue", 25, "Sep"));
        manatee.notifyDataSetChanged();
    }

    //display news list
    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<Adapter_calender_item> listnewsDataAdpater;

        public MyCustomAdapter(ArrayList<Adapter_calender_item> listnewsDataAdpater) {
            this.listnewsDataAdpater = listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_calender, null);

            final Adapter_calender_item s = listnewsDataAdpater.get(position);

            TextView eventName = (TextView) myView.findViewById(R.id.EventName);
            eventName.setText(s.EventName);

            TextView day = (TextView) myView.findViewById(R.id.Day);
            day.setText(s.Day);

            TextView day_No = (TextView) myView.findViewById(R.id.Day_No);
            day_No.setText(""+s.Day_No);

            TextView month = (TextView) myView.findViewById(R.id.Month);
            month.setText(s.Month);

            return myView;
        }

    }
}
