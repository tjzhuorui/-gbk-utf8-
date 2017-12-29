package com.rui.encodetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class CodeTest {

	public static void main(String[] args) {
		try {
			// 从utf8.txt里读取utf8编码的我爱你中国
			String utf8 = readFrom("doc/utf8.txt");
			// 转成gbk数组
			byte[] buffer = utf8.getBytes(Charset.forName("GBK"));
			// 打印
			printBufferByHex(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String readFrom(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[56];

		int len = fis.read(buffer);

		String utf8 = new String(buffer, 0, len, Charset.forName("UTF8"));
		// System.out.println(utf8);
		fis.close();
		return utf8;
	}

	private static void printBufferByHex(byte[] buffer) {
		for (int i = 0; i < buffer.length; i++) {
			String hex = printByteByHex(buffer[i]);
			System.out.print(hex + " ");
		}
	}

	private static String printByteByHex(byte b) {
		// 若为负数，高3字节填充ff，字符串总长度为8
		// 若为正数，则极可能不满8位
		String s = Integer.toHexString(b);

		// 缩减到两位
		if (s.length() > 2)
			s = s.substring(s.length() - 2, s.length());
		// System.out.println(s);

		// 扩充到两位
		if (s.length() < 2)// 其实只有可能是1
			s = "0" + s;
		// System.out.println(s);

		return "0x" + s;

	}

}
