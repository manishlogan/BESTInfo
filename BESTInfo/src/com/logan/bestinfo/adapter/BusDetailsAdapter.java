package com.logan.bestinfo.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.evolvingvision.bestinfo.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BusDetailsAdapter extends BaseAdapter{

	private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    
	public BusDetailsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
        if(convertView==null)
            view = inflater.inflate(R.layout.bus_details, null);
 
        TextView busNo = (TextView)view.findViewById(R.id.busNo);
        busNo.setTextSize(22);
        TextView description = (TextView)view.findViewById(R.id.description);
 
        HashMap<String, String> detail = new HashMap<String, String>();
        detail = data.get(position);
        busNo.setText(detail.get("busNo"));
        description.setText(detail.get("description"));
        description.setTextSize(20);
        return view;
	}
	
}
