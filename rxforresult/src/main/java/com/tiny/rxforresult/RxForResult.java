package com.tiny.rxforresult;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;

/**
 * RxActivityForResult.java
 * 类的描述信息
 *
 * @author tiny
 * @version 2016/12/02 11:12
 */
public class RxForResult {

	static final String TAG = "RxForResult";
	RxResultFragment mRxActivityResultFragment;

	public RxForResult(Activity activity) {

		mRxActivityResultFragment = getRxActivityResultFragment(activity);
	}

	public RxForResult appendRequestCode(int requestCode) {

		mRxActivityResultFragment.putRequestCode(requestCode);
		return this;
	}

	public RxForResult appendIntent(Intent intent) {

		mRxActivityResultFragment.putIntent(intent);
		return this;
	}

	public Observable<RxResultEntity> startReuqest() {

		PublishSubject<RxResultEntity> subject = PublishSubject.create();
		mRxActivityResultFragment.setSubjectActivityResult(subject);

		mRxActivityResultFragment.startRequest();
		return Observable.concat(Observable.just(subject)).observeOn(AndroidSchedulers.mainThread());
	}

	private RxResultFragment getRxActivityResultFragment(Activity activity) {

		RxResultFragment rxPermissionsFragment = findRxActivityResultFragment(activity);
		boolean isNewInstance = rxPermissionsFragment == null;
		if (isNewInstance) {
			rxPermissionsFragment = new RxResultFragment();
			FragmentManager fragmentManager = activity.getFragmentManager();
			fragmentManager.beginTransaction().add(rxPermissionsFragment, TAG).commit();
			fragmentManager.executePendingTransactions();
		}
		return rxPermissionsFragment;
	}

	private RxResultFragment findRxActivityResultFragment(Activity activity) {

		return (RxResultFragment) activity.getFragmentManager().findFragmentByTag(TAG);
	}
}
