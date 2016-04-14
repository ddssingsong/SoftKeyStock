package com.dds.softkeynumber;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

/**
 * 测试股票类代码
 * 
 * @author dds
 *
 */
public class MainActivity extends Activity {
	private EditText edit;
	private Context ctx;// 上下文
	private Activity act;// 本实例对象
	private KeyBoardNumber keyBoard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit = (EditText) findViewById(R.id.edit);
		ctx = this;
		act = this;
		keyBoard = new KeyBoardNumber(act, ctx, edit);

		// 设置其触摸事件
		edit.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int inputback = edit.getInputType();
				edit.setInputType(InputType.TYPE_NULL);
				keyBoard.showKeyboard();
				edit.setInputType(inputback);
				return false;
			}
		});
	}

	@Override
	public void onBackPressed() {

		/**
		 * 为了增加用户体验，还是加个这样的处理
		 */
		if (!keyBoard.isKeyBoardShow()) {
			super.onBackPressed();

		} else {
			keyBoard.hideKeyboard();
		}

	}

}
