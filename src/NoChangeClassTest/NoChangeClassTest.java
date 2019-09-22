package NoChangeClassTest;

/**
 * 不变模式：
 * 类，全局变量等都设置为final，并且只有一个初始化的地方，即是带参数的构造函数
 * @author JIEE_Shine
 *
 */
public final class NoChangeClassTest {
	
	private final String loginName;
	private final String passWord;
	
	public NoChangeClassTest(String loginName, String passWord) {
		super();
		this.loginName = loginName;
		this.passWord = passWord;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	@Override
	public String toString() {
		return "NoChangeClassTest [loginName=" + loginName + ", passWord=" + passWord + "]";
	}
	
	

}
