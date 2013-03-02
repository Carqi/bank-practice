package com.bankManagementSystem.adapter;

import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bankManagementSystem.domain.TextSpinnerItem;
import com.bankManagementSystem.main.R;

public class TextSpinnerAdapter implements ListAdapter {
	private List<TextSpinnerItem> list;
	
	/** ʵ�������Ӧ����ͼ���ֵ�XML�ļ� */
	private LayoutInflater layoutInflater;
	public TextSpinnerAdapter(Context context, List<TextSpinnerItem> list) {
		this.list = list;
		layoutInflater = LayoutInflater.from(context);
	}
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub

	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			// ���ز���
			convertView = layoutInflater.inflate(R.layout.certificates_adatper, null);
			// ���ò�������
			
			TextView tv_1 = (TextView) convertView.findViewById(R.id.certificates_content);
			tv_1.setText(list.get(position).getItemname());
		}
		return convertView;
	}

	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
		return true;
	}

}
