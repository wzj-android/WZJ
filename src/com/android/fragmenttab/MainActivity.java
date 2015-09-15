package com.android.fragmenttab;

import java.util.ArrayList;
import java.util.List;

import com.android.fragmenttab.util.Utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class MainActivity extends FragmentActivity {
	/**
	 * Called when the activity is first created.
	 */
	private RadioGroup rgs;
	public List<Fragment> fragments = new ArrayList<Fragment>();
	public String hello = "hello ";
	private SlidingMenu mslidingMenu;
	private Button mButton;
	private EditText codeEditText;
	private Button getCodeButton;
	private EditText phoneEditText;
	private Button regButton;

	final Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			int event = msg.arg1;
			int result = msg.arg2;
			Object data = msg.obj;

			if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
				// �ύ��֤��	
				Toast.makeText(getApplicationContext(), "ע��ɹ�", Toast.LENGTH_SHORT).show();
			} else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
				// ��ȡ��֤�� ����
				Toast.makeText(getApplicationContext(), "��֤�뷢�ͳɹ�", Toast.LENGTH_SHORT).show();
			}

			/*
			 * if (event == SMSSDK.EVENT_SUBMIT_USER_INFO) { //
			 * ����ע��ɹ��󣬷���MainActivity,Ȼ����ʾ�º��� if (result ==
			 * SMSSDK.RESULT_COMPLETE) { } else { ((Throwable)
			 * data).printStackTrace(); } } else if (event ==
			 * SMSSDK.EVENT_GET_NEW_FRIENDS_COUNT) { if (result ==
			 * SMSSDK.RESULT_COMPLETE) { } else { ((Throwable)
			 * data).printStackTrace(); } }
			 */
		}
	};
	EventHandler eventHandler = new EventHandler() {
		public void afterEvent(int event, int result, Object data) {
			Message msg = new Message();
			msg.arg1 = event;
			msg.arg2 = result;
			msg.obj = data;
			handler.sendMessage(msg);
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		SMSSDK.initSDK(this, "a611caf17b15", "aa586b6d4ecba194964d9726f92b8ae4");
		//SMSSDK.getVerificationCode("86", "18669520283");
		
		// ע��ص������ӿ�
		SMSSDK.registerEventHandler(eventHandler);
		
		fragments.add(new TabAFm());
		fragments.add(new TabBFm());
		fragments.add(new TabCFm());
		fragments.add(new TabDFm());
		fragments.add(new TabEFm());
		regButton = (Button) findViewById(R.id.left_menu_btn_reg);
		rgs = (RadioGroup) findViewById(R.id.tabs_rg);
		mslidingMenu = (SlidingMenu) findViewById(R.id.id_menu);
		mButton = (Button) findViewById(R.id.tab_top_id_btn);
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mslidingMenu.toggle();
			}
		});

		// ��ȡ��֤��
		regButton = (Button) findViewById(R.id.left_menu_btn_reg);
		codeEditText = (EditText) findViewById(R.id.left_menu_edt_code);
		getCodeButton = (Button) findViewById(R.id.left_menu_btn_getcode);
		phoneEditText = (EditText) findViewById(R.id.left_menu_edt_phone);
		// ��ȡ
		getCodeButton.setOnClickListener(new OnClickListener() {

			String phoneNum = phoneEditText.getText().toString().trim();

			@Override
			public void onClick(View v) {
				// �����ж�������ֻ���ʽ�Ƿ���ȷ

				if (true) {
					// �����ȡ������֤�� �й��Ĺ����� 86
					SMSSDK.getVerificationCode("86", phoneNum);
					count = 60;
					getCodeButton.setEnabled(false);
					timeHandle.post(runnable);
				} else {
					Toast.makeText(getApplicationContext(), "��������ȷ�ֻ���", Toast.LENGTH_SHORT).show();
				}

			}
		});
		// ע��
		regButton.setOnClickListener(new OnClickListener() {
			String phoneNum = phoneEditText.getText().toString().trim();
			String codeNum = codeEditText.getText().toString().trim();

			@Override
			public void onClick(View v) {
				if (codeNum != null && codeNum.length() > 0) {
					SMSSDK.submitVerificationCode("86", phoneNum, codeNum);
				}
				Toast.makeText(getApplicationContext(), "��������ȷ��֤��", Toast.LENGTH_SHORT).show();
			}
		});
		FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.tab_content, rgs);
		tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener() {
			@Override
			public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
				System.out.println("Extra---- " + index + " checked!!! ");
			}
		});

	}

	// ����ʱ
	private Handler timeHandle = new Handler();
	private int count = 60;
	private Runnable runnable = new Runnable() {

		@Override
		public void run() {
			count--;
			if (count == 0) {
				timeHandle.removeCallbacks(runnable);
				getCodeButton.setEnabled(true);
				getCodeButton.setText("��ȡ��֤��");
			} else {
				getCodeButton.setText("ʣ��" + count + "��");
				timeHandle.postDelayed(runnable, 1000);
			}
		}
	};

}
