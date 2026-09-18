
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Alan {

	public static String encode(byte[] text) {
		return Base64.getEncoder().encodeToString(text);
	}

	public static byte[] decode(String text) {
		return Base64.getDecoder().decode(text);
	}

	public static byte[] encrypt(byte[] cleartext, String key) {
		byte[] toReturn = new byte[cleartext.length];
		byte[] keyBytes = key.getBytes();
		for (int i = 0; i < cleartext.length; i++) {
			toReturn[i] = (byte) (cleartext[i] ^ keyBytes[i % keyBytes.length]);
		}
		return toReturn;
	}

	public static double kasaiki(String s) {
		HashMap<Character, Integer> frequency = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (frequency.containsKey(s.charAt(i))) {
				frequency.replace(s.charAt(i), frequency.get(s.charAt(i)) + 1);
			} else {
				frequency.put(s.charAt(i), 1);
			}
		}
		char character[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', '0', '=' };
		double ioc = 0;

		for (int i = 0; i < character.length; i++) {
			if (frequency.containsKey(Character.valueOf(character[i]))) {
				ioc += (frequency.get(Character.valueOf(character[i]))
						* (frequency.get(Character.valueOf(character[i])) - 1));
			}
		}
		ioc = ioc / (double) (s.length() * (s.length() - 1));
		
		
		return ioc;
	}

	public static byte maxByte(byte[] array) {
		HashMap<Byte, Integer> byteCountMap = new HashMap<>();

		for (byte c : array) {
			if (byteCountMap.containsKey(c)) {
				byteCountMap.put(c, byteCountMap.get(c) + 1);
			} else {
				byteCountMap.put(c, 1);
			}
		}

		Set<Entry<Byte, Integer>> entrySet = byteCountMap.entrySet();

		int maxCount = 0;

		byte maxChar = 0;

		for (Entry<Byte, Integer> entry : entrySet) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();

				maxChar = entry.getKey();
			}
		}

		Object[] a = byteCountMap.entrySet().toArray();
		Arrays.sort(a, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Map.Entry<Byte, Integer>) o2).getValue().compareTo(((Map.Entry<Byte, Integer>) o1).getValue());
			}
		});

		for (Object e : a) {
			System.out.println(
					((Map.Entry<Byte, Integer>) e).getKey() + " : " + ((Map.Entry<Byte, Integer>) e).getValue());
		}
		return maxChar;
	}

	public static void main(String[] args) {

		String cipherText = "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";
		byte decodedCipherText[] = decode(cipherText);
		
		int keyLength = kasaiki(new String(decodedCipherText)); // 5
		byte[][] decodedColumnCipherText = new byte[keyLength][decodedCipherText.length/5];

		for (int j = 0; j < keyLength; j++) {
			int counter = 0;
			for (int k = j; k < decodedCipherText.length; k += 5) {
				decodedColumnCipherText[j][counter++] = decodedCipherText[k];
			}
			
			System.out.print("\nThe amount of bytes read in are " + counter);

		}
		
		System.out.println("\n"+decodedCipherText[0]);
		for (int j = 0; j < keyLength; j++) {
			for (int k = 0; k < 402; k++) {
				System.out.print(decodedColumnCipherText[j][k] + " ");
			}
			System.out.println();

		}
		maxByte(decodedCipherText);
		


		byte temp1[] = { 77 };
		byte temp2[] = { 25 };
		byte temp3[] = { 19 };
		byte temp4[] = { 74 };
		byte temp5[] = { 92 };
		
		System.out.println(new String((encrypt(temp1, " "))) + "\n\n");
		System.out.println(new String((encrypt(temp1, "e"))) + "\n\n");
		System.out.println(new String((encrypt(temp1, "a"))) + "\n\n");
		System.out.println(new String((encrypt(temp1, "t"))) + "\n\n");
		System.out.println(new String((encrypt(temp1, "o"))) + "\n\n");
		
		
		System.out.println(new String((encrypt(temp2, " "))) + "\n\n");
		System.out.println(new String((encrypt(temp2, "e"))) + "\n\n");
		System.out.println(new String((encrypt(temp2, "a"))) + "\n\n");
		System.out.println(new String((encrypt(temp2, "t"))) + "\n\n");
		System.out.println(new String((encrypt(temp2, "o"))) + "\n\n");
		
		System.out.println(new String((encrypt(temp3, " "))) + "\n\n");
		System.out.println(new String((encrypt(temp3, "e"))) + "\n\n");
		System.out.println(new String((encrypt(temp3, "a"))) + "\n\n");
		System.out.println(new String((encrypt(temp3, "t"))) + "\n\n");
		System.out.println(new String((encrypt(temp3, "o"))) + "\n\n");
		
		System.out.println(new String((encrypt(temp4, " "))) + "\n\n");
		System.out.println(new String((encrypt(temp4, "e"))) + "\n\n");
		System.out.println(new String((encrypt(temp4, "a"))) + "\n\n");
		System.out.println(new String((encrypt(temp4, "t"))) + "\n\n");
		System.out.println(new String((encrypt(temp4, "o"))) + "\n\n");
		
		System.out.println(new String((encrypt(temp5, " "))) + "\n\n");
		System.out.println(new String((encrypt(temp5, "e"))) + "\n\n");
		System.out.println(new String((encrypt(temp5, "a"))) + "\n\n");
		System.out.println(new String((encrypt(temp5, "t"))) + "\n\n");
		System.out.println(new String((encrypt(temp5, "o"))) + "\n\n");
		
		String frequency1 = "m(,9\"";
		String frequency2 = "9|xmT"; // "t"
		String frequency3 = "3vrg|";
		String frequency4 = "j/+>%";// " "
		String frequency5 = "|9=(3"; // "o"
	
		
		System.out.println(new String(encrypt(decode(cipherText), "j39Tm")));

	}

}
