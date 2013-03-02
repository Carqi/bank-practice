package com.bankManagementSystem.adapter;

import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bankManagementSystem.domain.SecondMenu;
import com.bankManagementSystem.main.R;

public class ListMenuAdapter implements ListAdapter {
	private List<SecondMenu> secondMenu;
	/** ʵ�������Ӧ����ͼ���ֵ�XML�ļ� */
	private LayoutInflater layoutInflater;
	public ListMenuAdapter(Context context, List<SecondMenu> secondMenu) {
		this.secondMenu = secondMenu;
		//layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		return secondMenu.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return secondMenu.get(position);
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
			convertView = layoutInflater.inflate(secondMenu.get(position).getLayoutID(), null);
			// ���ò�������
			
			TextView tv_1 = (TextView) convertView.findViewById(R.id.secondmenucontent);
			tv_1.setText(secondMenu.get(position).getContent());
		}
		return convertView;
	}

	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return secondMenu.size();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * true������Ŀ��ѡ��ɵ��
	 */
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * �Ƿ���ʾ�ָ���
	 */
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
		return true;
	}

}
