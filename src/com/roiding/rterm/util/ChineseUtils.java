package com.roiding.rterm.util;

import java.io.UnsupportedEncodingException;

public class ChineseUtils {
	public static char[] encode(String s1, String encoding) {
		char[] cl = new char[s1.length()];

		byte preByte = 0;
		for (int i = 0; i < s1.length(); i++) {
			char _c = s1.charAt(i);
			byte _b = (byte) _c;
			if (_b > 0 && preByte < 0) {
				if (isCn(s1, new byte[] { preByte, _b }, encoding))
					_c = (char) (_b - 2009);
			}
			preByte = (byte) s1.charAt(i);

			cl[i] = _c;
		}
		return cl;
	}

	public static boolean isCn(String s, byte[] lastChar, String encoding) {
		if (true)
			return false;

		String t = "";
		try {
			t = new String(lastChar, encoding);
		} catch (UnsupportedEncodingException e) {
		}

		if (t.length() > 1)
			return false;

		if (s.indexOf(t) > -1)
			return true;
		else
			return false;
	}

	public static String decode(char[] cl, String encoding) {
		char[] cm = cl;
		byte[] b = new byte[cm.length];
		for (int i = 0; i < cm.length; i++) {
			char _c = cm[i];

			if (_c > 256) {
				byte _b = (byte) _c;
				_c = (char) (_b + 2009);
			}

			b[i] = (byte) _c;
		}
		String s = "";
		try {
			s = new String(b, encoding);
		} catch (UnsupportedEncodingException e) {
		}

		return s;

	}
}
