package com.bankManagementSystem.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bankManagementSystem.domain.TextSpinnerItem;
import com.bankManagementSystem.model.User;
import com.bankManagementSystem.util.BaseActivity;
import com.bankManagementSystem.util.RegexChk;

public class RegisterInputActivity extends BaseActivity implements
		OnClickListener {

	private static final String TAG = "RegisterInputActivity";
	private Button btn_return;
	private Button btn_next;
	private TextView textSpinner;
	private EditText et_Card;
	private EditText et_account;
	private EditText et_secondaccount;
	private EditText et_name;
	private EditText et_phone;
	private EditText et_password;
	private EditText et_secondpassword;
	private EditText et_address;
	private RelativeLayout layout;

	private List<TextSpinnerItem> list;
	public static int RESULT = 1;
	public static int REQUEST = 0;
	private String[] certificates = new String[] { "身份证", "学生证", "出生证", "护照",
			"其他证件" };
	String certificate = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.self_reg_input_view);
		setupView();
		textSpinner.setText(certificates[0]);
		textSpinner.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		btn_return.setOnClickListener(this);
		list = new ArrayList<TextSpinnerItem>();
		// 赋值实体类对象
		for (int i = 0; i < certificates.length; i++) {
			TextSpinnerItem textItem = new TextSpinnerItem();
			textItem.setItemid(i);
			textItem.setItemname(certificates[i]);
			list.add(textItem);
		}
		layout.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					System.out.println("ACTION_DOWN");
					Log.i(TAG, String.valueOf(v.isPressed()));
					layout.setBackgroundColor(Color.parseColor("#BEBEBE"));
					break;
				case MotionEvent.ACTION_UP:
					System.out.println("ACTION_UP");
					Log.i(TAG, String.valueOf(v.isPressed()));
					layout.setBackgroundColor(Color.TRANSPARENT);
					Intent intent = new Intent(getApplicationContext(),
							TextItemActivity.class);
					intent.putExtra("certificates", certificates);
					startActivityForResult(intent, 200);
					break;
				case MotionEvent.ACTION_MOVE:
					System.out.println("ACTION_MOVE");
					layout.setBackgroundColor(Color.TRANSPARENT);
					break;
				}
				return false;
			}
		});
		btn_next.setOnClickListener(this);
	}

	// 加载各View控件
	private void setupView() {
		btn_return = (Button) findViewById(R.id.returnButton);
		btn_next = (Button) findViewById(R.id.nextButton);
		textSpinner = (TextView) findViewById(R.id.CertificateTextSpinner);
		et_Card = (EditText) findViewById(R.id.CardNum);
		et_account = (EditText) findViewById(R.id.account);
		et_secondaccount = (EditText) findViewById(R.id.second_account);
		et_name = (EditText) findViewById(R.id.Name);
		et_phone = (EditText) findViewById(R.id.Telephone);
		et_password = (EditText) findViewById(R.id.Password);
		et_secondpassword = (EditText) findViewById(R.id.PasswordConfirm);
		et_address = (EditText) findViewById(R.id.address);
		layout = (RelativeLayout) findViewById(R.id.Certificate_Layout);

	}

	public void onClick(View v) {
		if (v == textSpinner) {
			v.setOnTouchListener(new OnTouchListener() {
				
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:
							layout.setBackgroundColor(Color.parseColor("#BEBEBE"));
							break;
						case MotionEvent.ACTION_UP:
							layout.setBackgroundColor(Color.TRANSPARENT);
							break;
						case MotionEvent.ACTION_MOVE:
							layout.setBackgroundColor(Color.TRANSPARENT);
							break;
					}
					return false;
				}
			});
			Intent intent = new Intent(this, TextItemActivity.class);
			intent.putExtra("certificates", certificates);
			startActivityForResult(intent, 200);

		} else if (v == btn_next) {
			String indetify = et_Card.getText().toString();
			String account = et_account.getText().toString();
			String secondaccount = et_secondaccount.getText().toString();
			String username = et_name.getText().toString();
			String phone = et_phone.getText().toString();
			String password = et_password.getText().toString();
			String secondPassword = et_secondpassword.getText().toString();
			String address = et_address.getText().toString();
			if (null == indetify || indetify.equals("")) {
				Toast.makeText(this, "证件号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (indetify.length() != 18) {
				Toast.makeText(this, "证件号码格式不对", Toast.LENGTH_SHORT).show();
				return;
			}
			if (null == account || account.equals("")) {
				Toast.makeText(this, "用户账号不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (!account.equals(secondaccount)) {
				Toast.makeText(this, "账号输入不一致，请重新输入", Toast.LENGTH_SHORT)
						.show();
				return;
			}
			if (null == username || username.equals("")) {
				Toast.makeText(this, "用户姓名不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (null == phone || phone.equals("")) {
				Toast.makeText(this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (phone.length() != 11) {
				Toast.makeText(this, "手机号码格式有误", Toast.LENGTH_SHORT).show();
				return;
			} 
			if (phone.length() == 11) {
				RegexChk regexChk = new RegexChk();
				boolean result = regexChk.checkCellPhone(phone);
				if(!result){
					Toast.makeText(this, "手机号码格式有误", Toast.LENGTH_SHORT).show();
					return;
				}
			} 
			if (null == password || password.equals("")) {
				Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (password.length() < 6 || password.length() > 30) {
				Toast.makeText(this, "密码格式错误", Toast.LENGTH_SHORT).show();
				return;
			}
			if (!password.equals(secondPassword)) {
				Toast.makeText(this, "密码输入不一致，请重新输入", Toast.LENGTH_LONG).show();
				return;
			}
			if (null == address || address.equals("")) {
				Toast.makeText(this, "地址不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			User user = new User();
			user.setCertificate(certificate);
			user.setIndetify(et_Card.getText().toString());
			user.setAccount(et_account.getText().toString());
			user.setUsername(et_name.getText().toString());
			user.setPhone(et_phone.getText().toString());
			user.setPassword(et_secondpassword.getText().toString());
			user.setAddress(et_address.getText().toString());
			user.setTime(getTime());
			Intent nextIntent = new Intent(this, RegisterConfirmActivity.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("user", user);
			nextIntent.putExtras(bundle);
			startActivity(nextIntent);
		} else {
			setResult(RESULT);
			finish();
		}
	}

	// 获得当前时间，按XX-XX-XX输出
	private String getTime() {
		String time = null;
		Calendar calendar = Calendar.getInstance();
		time = calendar.get(Calendar.YEAR) + "-"
				+ (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DATE);
		return time;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == 30) {
			certificate = data.getStringExtra("certificate");
			textSpinner.setText(certificate);
		}
	}

}
