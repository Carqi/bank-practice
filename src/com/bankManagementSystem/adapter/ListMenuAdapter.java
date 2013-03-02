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
	/** 实例及其对应的视图布局的XML文件 */
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
			// 加载布局
			convertView = layoutInflater.inflate(secondMenu.get(position).getLayoutID(), null);
			// 设置布局内容
			
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
	 * true所有项目可选择可点击
	 */
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 是否显示分割线
	 */
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
		return true;
	}

}
