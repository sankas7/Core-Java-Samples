package com.prog.samples.java9;

public interface UtilInterface {

	
	 default int getNumberOfCore()
	{
		return getNumberOfCoreHelper();
	}
	 
	static int getResult()
	{
		return getNumberOfCoreHelperStatic();
	}
	 private int getNumberOfCoreHelper()
	 {
		 return 4;
	 }
	 
	 private static int getNumberOfCoreHelperStatic()
	 {
		 return 5;
	 }
}
