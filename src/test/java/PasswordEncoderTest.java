import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 */

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
public class PasswordEncoderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
		System.out.println(encoder.encode("123456"));
	}

}
