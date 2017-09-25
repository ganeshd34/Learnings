package com.ganesh.TestProject.helloWorld;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateLargeFile{
	public static void main(String[] arg){
		long start = System.currentTimeMillis();
		BufferedWriter bw =null;
		String newLiner = System.getProperty("line.separator");
		try {
			bw = new BufferedWriter(new FileWriter("test1.csv",true));
			StringBuilder csvData = null;
			int count =0;
			for(int i=0;i<1000000;i++){
			//writeTofile("Name,Val,"+i);
			
				if(csvData==null){
					csvData = new StringBuilder();
				}
				csvData.append("Name,Val,"+i);
				csvData.append(newLiner);
				
				if(count>=0){
					bw.write(csvData.toString());
					bw.flush();
					csvData=null;
					count=0;
				}
				count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Total Time Taken:"+ (end-start));
	}

	public static void writeTofile(String txt) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("test1.csv",true))){
			bw.write(txt);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
