package com.bankManagementSystem.main;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.bankManagementSystem.adapter.TextSpinnerAdapter;
import com.bankManagementSystem.domain.TextSpinnerItem;
import com.bankManagementSystem.util.BaseActivity;


public class TextItemActivity extends BaseActivity {
	
	private static final String TAG = "TextItemActivity";
	private ListView listView;
	private List<TextSpinnerItem> list;
	private String[] certificates;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_certificates_view);
		Intent intent = getIntent();
		certificates = intent.getStringArrayExtra("certificates");
		list = new ArrayList<TextSpinnerItem>();
		//赋值实体类对象
		for(int i=0; i<certificates.length; i++){
			TextSpinnerItem textItem = new TextSpinnerItem();
			textItem.setItemid(i);
			textItem.setItemname(certificates[i]);
			list.add(textItem);
		}
		listView = (ListView)this.findViewById(R.id.certificateslistView);
		TextSpinnerAdapter textAdapter = new TextSpinnerAdapter(this, list);
		listView.setAdapter(textAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				intent.putExtra("certificate", certificates[position]);
				Log.i(TAG, certificates[position]);
				setResult(30, intent);
				finish();
				
			}
		});
	}
	
}
