



public class ZigzagConversion2Java {
	public String convert(String s, int numRows) {
		int n = s.length(), cycle = numRows * 2 - 2;
		if (numRows == 1) return s;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < n - i; j += cycle) {
				ans.append(s.charAt(i + j));
				if (i != 0 && i != numRows - 1 && j < (n + i - cycle)) {
					ans.append(s.charAt(j - i + cycle));
				}
			}
		}
		return ans.toString();
	}
	public static void main(String args[]) {
		String s = "paypalishiring";
		System.out.println(new ZigzagConversion2Java().convert(s, 3));
	}
}