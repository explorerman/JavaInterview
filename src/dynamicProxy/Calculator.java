package dynamicProxy;

import java.io.Serializable;

public interface Calculator extends Serializable {
  
    void add(int a, int b);
	void subtract(int a, int b);
	
}
