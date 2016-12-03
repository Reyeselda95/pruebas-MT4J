package myApp;

import org.mt4j.MTApplication;

public class MyMT4JApp extends MTApplication{

	/**
	 * Serial de la app
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		initialize();
	}
	
	@Override
	public void startUp() {
		addScene(new ExampleScene(this));		
	}

}
