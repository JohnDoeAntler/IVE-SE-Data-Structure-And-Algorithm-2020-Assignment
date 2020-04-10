package app.Until;

import java.util.Scanner;

public class ScannerSingleton {

	//
	// ─── SINGLETON FIELD ────────────────────────────────────────────────────────────
	//
	private volatile static Scanner singleton;
	
	//
	// ─── BLOCK INSTANTIATION ────────────────────────────────────────────────────────
	//
	private ScannerSingleton (){}

	//
	// ─── GET INSTANCE ───────────────────────────────────────────────────────────────
	//
	public static Scanner getInstance() {
		// double-checked locking singleton pattern
		if (singleton == null) {
			synchronized (Scanner.class) {
				if (singleton == null) {
					singleton = new Scanner(System.in);
				}
			}
		}
		return singleton;
	}
}