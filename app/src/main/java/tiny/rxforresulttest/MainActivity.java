package tiny.rxforresulttest;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tiny.rxforresult.RxForResult;
import com.tiny.rxforresult.RxResultEntity;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				new RxForResult(MainActivity.this).appendIntent(intent).appendRequestCode(10).startReuqest()
						.subscribe(new Action1<RxResultEntity>() {

							@Override
							public void call(RxResultEntity rxResultEntity) {

							}
						});
			}
		});

		findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Fragment mfragment = new TestFragment();
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction mFtransaction = fragmentManager.beginTransaction();
				mFtransaction.add(R.id.content, mfragment, "111");
				mFtransaction.show(mfragment);
				mFtransaction.commitAllowingStateLoss();
			}
		});
	}
}
