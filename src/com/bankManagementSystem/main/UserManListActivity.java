package com.bankManagementSystem.main;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bankManagementSystem.adapter.ListMenuAdapter;
import com.bankManagementSystem.domain.SecondMenu;
import com.bankManagementSystem.util.BaseActivity;

/*
 用户登录进去的主界面                        
 */
public class UserManListActivity extends BaseActivity {
	private static final String TAG = "UserManListActivity";
	public List<SecondMenu> list;
	private int images[] = { R.drawable.preferential_shop,
			R.drawable.preferential_shop, R.drawable.preferential_shop };
	private String functions[] = { "用户查询", "修改密码", "用户转账" };
	private Button btn;
	private ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Here~~~~~~~~44");
		setContentView(R.layout.listmenuview);
		btn = (Button) findViewById(R.id.btn_back);
		listView = (ListView) this.findViewById(R.id.secondMenulistView);
		list = new ArrayList<SecondMenu>();
		Log.i(TAG, "Here~~~~~~~~48");
		// 赋值实体类对象
		for (int i = 0; i < functions.length; i++) {
			SecondMenu secondM = new SecondMenu();
			secondM.setLayoutID(R.layout.secondmenuadatper);
			secondM.setContent(functions[i]);
			secondM.setBitmap(R.drawable.ic_launcher);
			list.add(secondM);
		}
		// 返回按钮
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent backIntent = new Intent();
				backIntent.setClass(UserManListActivity.this,
						UserActivity.class);
				UserManListActivity.this.startActivity(backIntent);

			}
		});
		Log.i(TAG, list.get(2).getContent().toString());
		ListMenuAdapter listAdapter = new ListMenuAdapter(this, list);
		listView.setAdapter(listAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				switch (position) {
				case 0:
					intent.setClass(UserManListActivity.this,
							UserManQueryActivity.class);
					break;
				case 1:
					intent.setClass(UserManListActivity.this,
							UserManUpdatePwdActivity.class);
					break;
				case 2:
					intent.setClass(UserManListActivity.this,
							UserManTransferAccountsActivity.class);
					break;
				}
				UserManListActivity.this.startActivity(intent);
			}
		});
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.containermenu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.set:
			startActivity(new Intent(Settings.ACTION_SETTINGS));

			break;

		case R.id.exit:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("你确定要退出吗？");
			builder.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							UserManListActivity.this.exit();
						}
					});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {

						}
					});
			builder.create().show();

			break;
		}
		return super.onOptionsItemSelected(item);
	}

}