package com.prog.samples.threading;



import java.lang.Thread.UncaughtExceptionHandler;



/**
 * An {@link UncaughtExceptionHandler} implementation chaining 2 other implementations.
 * <p>
 * Use this class to chain {@link UncaughtExceptionHandler}s together, e.g. to register
 * your {@link UncaughtExceptionHandler} on top of the one that was already registered.
 *
 * @author Guy Rooms
 * 
 * @see Thread#setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler)
 */
public final class UncaughtExceptionHandlerPair implements UncaughtExceptionHandler {
	
	
	
	private final UncaughtExceptionHandler original;
	private final UncaughtExceptionHandler additional;
	private final String msOriginalName;
	private final String msAdditionalName;
	
	/**
	 * Constructor to chain (two) {@link UncaughtExceptionHandler}s together.
	 * <p>
	 * Keep in mind they will be called in reverse order !
	 * 
	 * @param original   The original UncaughtExceptionHandler, null is allowed.
	 * @param additional The additional UncaughtExceptionHandler, null is allowed.
	 */
	public UncaughtExceptionHandlerPair(UncaughtExceptionHandler original, UncaughtExceptionHandler additional) {
		this.original = original;
		this.additional = additional;
		//Construct info message up front to avoid memory allocations during uncaught exception handling
		this.msOriginalName = original == null ? "" : 
			"Delegating throwable to original UncaughtExceptionHandler " + original.getClass().getName();
		this.msAdditionalName = additional == null ? "" : 
			"Delegating throwable to second UncaughtExceptionHandler " + additional.getClass().getName();
	}
	
	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		if (additional != null) {
			try {
				System.out.print(msAdditionalName);
				additional.uncaughtException(thread, throwable);
			} catch (Throwable t) {
				// NOP
			}
		}
		if (original != null) {
			try {
				System.out.print(msOriginalName);
				original.uncaughtException(thread, throwable);
			} catch (Throwable t) {
				// NOP
			}
		}
	}
}
