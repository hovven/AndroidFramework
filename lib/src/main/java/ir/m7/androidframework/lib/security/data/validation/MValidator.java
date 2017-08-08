package ir.m7.androidframework.lib.security.data.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by milad on 10/30/15.
 */
public class MValidator {

    public static boolean checkMatching(String inputText, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public class MRegularExpression {
        public static final String PERSIAN_NAME_PATTERN = "[\\u0600-\\u06FF]+";
        public static final String ENGLISH_NAME_PATTERN = "[a-zA-Z]+";
        public static final String MOBILE_NUMBER_PATTERN = "^(0|(\\+?98))9([0-3])\\d-?[0-9]{3}-?[0-9]{4}$";
        public static final String NATIONAL_CODE_PATTERN = "\\d{10}";
        public static final String MEDiCAL_SYSTEM_NUMBER_PATTERN = "\\d{4,10}";
        public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[A-Za-z]).{6,20})";
        public static final String PASSWORD2_PATTERN = "((?=.*\\d.*)(?=.*[a-z].*)(?=.*[A-Z].*).{6,20})";
    }
}
