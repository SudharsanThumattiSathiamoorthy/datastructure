package com.sudharsan.examples;

public class TinyUrl {

	static public void main(final String[] args) {
		String tinyURL = convertIdIntoTinyUrl(12345);
		int id = convertURLIntoInt(tinyURL);
		System.out.println(id);
	}

	private static int convertURLIntoInt(String tinyURL) {
		int id = 0;
		char temp[] = tinyURL.toCharArray();
		for (int i= 0; i < tinyURL.length() ; i++) {
			if (tinyURL.charAt(i) >= 'a' && tinyURL.charAt(i) <= 'z') {
				id = (id *62) + temp[i] - 'a';
			} 
			if (tinyURL.charAt(i) >= 'A' && tinyURL.charAt(i) <= 'Z') {
				id = (id * 62) + temp[i] - 'A' + 26;
			}
			if (tinyURL.charAt(i) >= '0' && tinyURL.charAt(i) <= '9') {
				id = (id * 62) + temp[i] - '0' + 52;
			}
		}
		return id;
	}

	private static String convertIdIntoTinyUrl(int no) {
		char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		String tinyUrl = "";
		
		while(no > 0) {
			tinyUrl += map[no%62];
			no /= 62;
		}
		return reverse(tinyUrl);
	}

	private static String reverse(final String tinyUrl) {
		if (tinyUrl == null) {
			return null;
		}
		int start = 0, end = tinyUrl.length() -1;
		char[] a = tinyUrl.toCharArray();

		while(start < end) {
			swap(a, start, end);
			start++;
			end--;
		}
		return String.valueOf(a);
	}

	private static void swap(char[] a, int start, int end) {
		char temp = a[start];
		a[start] = a[end];
		a[end] = temp;
	}
}
