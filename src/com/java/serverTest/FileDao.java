package com.java.serverTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileDao {

	static final String FILENAME = "FileCounter.intial";
	
	public int getCount(){
		
		int count = 0;
		
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try{
			
			File f = new File(FILENAME);
			if(!f.exists()){
				f.createNewFile();
				pw = new PrintWriter(new FileWriter(f));
				pw.println(0);	
			}
			
			if( pw != null){
				pw.close();
			}
			
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String initial = br.readLine();
			count = Integer.parseInt(initial);
			
		}catch(Exception e){
			if(pw != null){
				pw.close();
			}
		}
		if(br != null){
			try{
				br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public void save(int count) throws Exception{
		
		FileWriter fw = new FileWriter(FILENAME);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(count);
				
		if(pw != null){
			pw.close();
		}
	}
}
