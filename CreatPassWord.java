import java.util.Random;

public class CreatPassWord {

	private static final String Upper_Case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String Lower_Case = Upper_Case.toLowerCase();
	private static final String Symbols = "!@#$%*{}[]()";
	private static final String Numbers = "0123456789";

	public static void main(String[] args) {

		System.out.println("Password of weak strength : " + new CreatPassWord().getPassword(1, 7));
	}

	private String generatePassword(int length, String ref) {
		Random r = new Random();
		char[] referChars = ref.toCharArray();
		char[] passChars = new char[length];
		for (int i = 0; i < length; i++) {
			passChars[i] = referChars[r.nextInt(referChars.length)];
		}
		String password = new String(passChars);
		return password;
	}

	public String getPassword(int Strength, int Length) {
		String password = null;
		if ((Length >= 6) && (Length <= 10) && (Strength > 0) && (Strength < 4)) {
			if (Strength == 1) {
				password = generatePassword(Length, (Lower_Case.concat(Upper_Case)));
			} else if (Strength == 2) {
				password = generatePassword(Length, (Lower_Case.concat(Upper_Case).concat(Numbers)));
			} else if (Strength == 3) {
				password = generatePassword(Length, (Lower_Case.concat(Upper_Case).concat(Numbers).concat(Symbols)));
			}
		}

		else {
			System.out.println("Length of Pssword out of limit ");
		}
		return password;

	}

}
