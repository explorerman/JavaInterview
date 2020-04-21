package futureTest;

public class FutureData implements Data {
	protected RealData realData = null;
	protected boolean isReady = false;

	public synchronized void setRealData(RealData realData) {
		System.out.println("set中的is————"+isReady);
		if(isReady){
			return;
		}
		System.out.println("future也准备好了" + isReady + "_" + realData.getResult());
		this.realData = realData;
		isReady = true;
		notifyAll();
	}
	
	@Override
	public synchronized String getResult() {
		System.out.println("使用了future的result__" + isReady);
		while (!isReady) {
			try {
				System.out.println("isReady没有准备好" + isReady+"-需要准备好数据才行");
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return realData.getResult();
	}

}
