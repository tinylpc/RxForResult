# RxForResult
用Obserable形式实现的startActivityForResult

# 调用方式
`
  new RxForResult(MainActivity.this).appendIntent(intent).appendRequestCode(10).startReuqest()
	.subscribe(new Action1<RxResultEntity>() {
	@Override
	public void call(RxResultEntity rxResultEntity) {
	}
	});
`
