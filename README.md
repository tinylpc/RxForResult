# RxForResult
用Obserable形式实现的startActivityForResult

# 引用方式
`
compile 'com.tinylpc:rxforresult:1.0.0's
`

# 调用方式
`
  new RxForResult(MainActivity.this).appendIntent(intent).appendRequestCode(10).startReuqest()
	.subscribe(new Action1<RxResultEntity>() {
	@Override
	public void call(RxResultEntity rxResultEntity) {
	}
	});
`
