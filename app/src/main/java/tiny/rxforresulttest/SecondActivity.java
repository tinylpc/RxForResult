package tiny.rxforresulttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * SecondActivity.java
 * 类的描述信息
 *
 * @author tiny
 * @version 2016/12/02 15:39
 *          CopyRight www.eku001.com
 */
public class SecondActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);

		findViewById(R.id.btn_test_activity).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent();
				intent.putExtra("test_activity", 99);
				setResult(100, intent);
				finish();
			}
		});
	}
}
