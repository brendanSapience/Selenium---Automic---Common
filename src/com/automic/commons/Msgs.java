package com.automic.commons;

public class Msgs {

	public static void showInfo(String s){
		System.out.println("\t %% Info: " + s);
	}
	
	public static void showError(String s){
		System.out.println("\t -- Error: " + s);
	}
	
	public static void showSuccess(String s){
		System.out.println("\t ++ Success: " + s);
	}
	
	public static void showButtonFound(){
		System.out.println("\t ++ Element Found!");
	}
}
