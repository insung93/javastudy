package iost;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class IOEx01 {

	public static void main(String[] args) {
		byte[] in = {0,1,2,3,4,5,6,7,8,9};
		byte[] out = null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(in);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		while ((data=input.read())!=-1) {
			output.write(data);
		}
		
		out = output.toByteArray();
		
		for(int i = 0 ;i< out.length;i++) {
			System.out.println(out[i]);
		}
		
		
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
