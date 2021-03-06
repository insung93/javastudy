package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			FileWriter fw = new FileWriter("BufferedReaderTest.txt");
			//보조 스트림
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			String line = null;
			
			int index = 0;
			while((line = br.readLine()) != null ) {
				index++;
				System.out.print(index);
				System.out.print(" ");
				System.out.print(line);
				System.out.println();
				bw.write(line+"\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(br!= null) {
					br.close();
				}
				if(bw!= null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
