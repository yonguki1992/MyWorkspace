package com.kyu.nioPractice;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
		InetAddress ip, ips[];
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println(ip);
			System.out.println(ip.getHostName());
			System.out.println(Arrays.toString(ip.getAddress()));
			System.out.println("내주소 : "+InetAddress.getLocalHost());
			System.out.println("내주소 : "+InetAddress.getLoopbackAddress());
			
			ips = InetAddress.getAllByName("naver.com");
			
			for(InetAddress var : ips) {
				System.out.println(var);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
