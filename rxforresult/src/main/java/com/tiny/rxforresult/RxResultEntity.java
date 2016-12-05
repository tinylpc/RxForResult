package com.tiny.rxforresult;

import android.content.Intent;

/**
 * RxActivityResultEntity.java
 * 类的描述信息
 *
 * @author tiny
 * @version 2016/12/02 11:32
 */
public class RxResultEntity {

	public int requestCode;

	public int resultCode;

	public Intent data;

	public int getResultCode() {

		return resultCode;
	}

	public void setResultCode(int resultCode) {

		this.resultCode = resultCode;
	}

	public Intent getData() {

		return data;
	}

	public void setData(Intent data) {

		this.data = data;
	}

	public int getRequestCode() {

		return requestCode;
	}

	public void setRequestCode(int requestCode) {

		this.requestCode = requestCode;
	}

	@Override
	public String toString() {

		final StringBuffer sb = new StringBuffer("RxActivityResultEntity{");
		sb.append("requestCode=").append(requestCode);
		sb.append(", resultCode=").append(resultCode);
		sb.append(", data=").append(data);
		sb.append('}');
		return sb.toString();
	}
}
