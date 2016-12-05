package tiny.rxforresulttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiny.rxforresult.RxForResult;
import com.tiny.rxforresult.RxResultEntity;

import rx.functions.Action1;

/**
 * TestFragment.java
 * 类的描述信息
 *
 * @author tiny
 * @version 2016/12/02 15:52
 */
public class TestFragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.test_fragment, container, false);
		view.findViewById(R.id.btn_test_fragment).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent intent = new Intent(getActivity(), SecondActivity.class);
				new RxForResult(getActivity()).appendIntent(intent).appendRequestCode(20).startReuqest()
						.subscribe(new Action1<RxResultEntity>() {

							@Override
							public void call(RxResultEntity rxResultEntity) {

								Log.i("lpc", rxResultEntity.toString());
							}
						});
			}
		});
		return view;
	}
}
