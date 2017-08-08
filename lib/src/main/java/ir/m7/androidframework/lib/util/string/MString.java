package ir.m7.androidframework.lib.util.string;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mahdavi on 03/01/2015.
 */
public class MString {

    public static String[] stringTokenizer(String input, String delimiters) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, delimiters);
        String[] s = new String[stringTokenizer.countTokens()];
        for (int i = 0; i < s.length; i++) {
            s[i] = stringTokenizer.nextToken();
        }
        return s;
    }

    public static String escapeUnicodeCharacter(String source) {
        Pattern pattern = Pattern.compile("\\\\u(\\p{XDigit}{4})");
        Matcher matcher = pattern.matcher(source);
        StringBuffer stringBuffer = new StringBuffer(source.length());
        while (matcher.find()) {
            String ch = String.valueOf((char) Integer.parseInt(matcher.group(1), 16));
            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(ch));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
