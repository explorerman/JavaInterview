package futureTest;

public class Client {

	public Data request(final String queryStr){
		final FutureData future = new FutureData();
		new Thread(){
			public void run() {
				RealData realData = new RealData(queryStr);
				System.out.println("realData数据已经准备好了" + realData.getResult());
				future.setRealData(realData);
			};
		}.start();
		
		return future;
	}
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name_");
		System.out.println("请求完毕");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("数据 = " + data.getResult());
	}

}
