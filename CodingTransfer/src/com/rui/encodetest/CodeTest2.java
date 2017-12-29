package com.rui.encodetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class CodeTest2 {
	public static void main(String[] args) throws IOException {
		String str1 = readFrom("doc/gbk.txt", "GBK");
		System.out.println("str1=[" + str1 + "]");
		String str2 = readFrom("doc/utf8.txt", "UTF8");
		System.out.println("str2=[" + str2 + "]");
		System.out.println("str1.equals(str2)=[" + str1.equals(str2) + "]");
	}

	private static String readFrom(String path, String charset) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[56];

		int len = fis.read(buffer);

		String str = new String(buffer, 0, len, Charset.forName(charset));
		// System.out.println(utf8);
		fis.close();
		return str;
	}
}
