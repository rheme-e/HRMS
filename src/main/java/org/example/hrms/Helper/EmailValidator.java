package org.example.hrms.Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isEmailMatchingDomain(String email, String website) {
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            String[] parts = email.split("@");
            return parts.length == 2 && parts[1].equalsIgnoreCase(website);
        }
        return false;
    }



}
