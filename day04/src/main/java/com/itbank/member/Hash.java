package com.itbank.member;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

public static String getHash(String userpw) {
		
		try {
//			Secure Hash Algorithm 512 : 입력값이 같으면 출력결과도 같으며, 출력결과는 다른값과 중복되지 않음을 보장하는 알고리즘
//			2^512
			MessageDigest md = MessageDigest.getInstance("SHA-512");	
			md.reset();
			md.update(userpw.getBytes("UTF-8"));
			String ret = String.format("%0128x", new BigInteger(1, md.digest()));
			return ret;
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("그런 알고리즘은 없습니다 : " + e);
//			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("그런 인코딩은 없습니다 : " + e);
//			e.printStackTrace();
		}
		
		return null;
	}
}
