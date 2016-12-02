package com.tiny.rxforresult;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import rx.subjects.PublishSubject;

public class RxResultFragment extends Fragment {

	private PublishSubject<RxResultEntity> subject;
	private Intent intent;
	private int requestCode;

	public RxResultFragment() {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	public void putIntent(Intent intent) {

		this.intent = intent;
	}

	public void putRequestCode(int requestCode) {

		this.requestCode = requestCode;
	}

	void startRequest() {

		startActivityForResult(intent, requestCode);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		onRequestActivityResult(requestCode, resultCode, data);
	}

	void onRequestActivityResult(int requestCode, int resultCode, Intent data) {

		RxResultEntity entity = new RxResultEntity();
		entity.setRequestCode(requestCode);
		entity.setResultCode(resultCode);
		entity.setData(data);
		subject.onNext(entity);
		subject.onCompleted();
	}

	public PublishSubject<RxResultEntity> getSubjectActivityResult() {

		return this.subject;
	}

	public void setSubjectActivityResult(@NonNull PublishSubject<RxResultEntity> subject) {

		this.subject = subject;
	}
}
