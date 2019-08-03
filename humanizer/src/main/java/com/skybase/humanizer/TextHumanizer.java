package com.skybase.humanizer;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHumanizer {

    private static final String REGEX_WHITESPACE_CHARACTERS = "\\s+";
    private static final String REGEX_SPACIAL_CHAR_FOR_AVOID_SPACE = "[.,?!]";
    private static final String REGEX_SPACIAL_CHAR_IN_FIST_PLACE = "^[\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\\\\\^\\_\\`\\~]";
    private static final String SPACE = " ";

    public static final int TITLE_CAPS = 968;
    public static final int TITLE = 42;
    public static final int NAME = TITLE;
    public static final int SENTENCE = 878;

    /**
     * Method return given String to human Readable format.
     *
     * @param humanizerValue String value to convert in human Readable format.
     * @param flag           Type Flag which specify how string should be formatted.
     */
    public static String humanize(String humanizerValue, @HumanizerTextTypes int flag) {
        try {
            switch (flag) {
                case TITLE_CAPS:
                    return humanizeTitleCaps(humanizerValue);
                case TITLE:
                    return humanizeTitle(humanizerValue);
                case SENTENCE:
                    return humanizeSentence(humanizerValue);
            }
            return humanizerValue;
        } catch (Exception e) {
            return humanizerValue;
        }
    }

    /**
     * Method return given String to human Readable format.
     * Equivalent to {@link TextHumanizer#humanize(String, int)} with default flag as {@link TextHumanizer#SENTENCE}
     *
     * @param humanizerValue String value to convert in human Readable format.
     */
    public static String humanize(String humanizerValue) {
        return humanize(humanizerValue, SENTENCE);
    }

    /**
     * Method return humanizerValue by converting it to Sentence Case
     */
    private static String humanizeSentence(String humanizerValue) {
        humanizerValue = removeUnwantedSpaces(humanizerValue).toLowerCase();
        int pos = 0;
        boolean capitalize = true;
        StringBuilder sb = new StringBuilder(humanizerValue);
        while (pos < sb.length()) {
            if (sb.charAt(pos) == '.') {
                capitalize = true;
            } else if (capitalize && Character.isLetterOrDigit(sb.charAt(pos))) {
                sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
                capitalize = false;
            }
            pos++;
        }
        return sb.toString().trim();
    }

    /**
     * Method return humanizerValue by converting it to Pascal Case
     */
    private static String humanizeTitle(String humanizerValue) {
        humanizerValue = removeUnwantedSpaces(humanizerValue).toLowerCase();
        String[] worlds = humanizerValue.split(SPACE);
        StringBuilder value = new StringBuilder();

        for (String world : worlds) {
            if (world.isEmpty()) {
                continue;
            }
            if (world.length() == 1) {
                value.append(world.toUpperCase());

                if (isSentenceStopper(world)) {
                    value.deleteCharAt(value.lastIndexOf(SPACE));
                }
            } else {
                int startIndex = (Character.isLetterOrDigit(world.codePointAt(0))) ? 1 : 2;
                value.append(world.substring(0, startIndex).toUpperCase());
                value.append(world.substring(startIndex));
            }
            value.append(SPACE);
        }
        return value.toString().trim();
    }

    /**
     * Method Return humanizerValue by changing its case to upper case
     */
    private static String humanizeTitleCaps(String humanizerValue) {
        humanizerValue = removeUnwantedSpaces(humanizerValue);
        return humanizerValue.trim().toUpperCase();
    }

    /**
     * Remove First Occurrence and prefix text from String
     */
    public static String humanizeTitleForParent(String title, String parentTitle) {
        try {
            if (!title.trim().equalsIgnoreCase(parentTitle.trim())) {
                title = title.replace(title.substring(0, title.indexOf(parentTitle)), "");
                if (title.startsWith(parentTitle)) {
                    title = title.replace(parentTitle, "");
                    title = title.trim();
                    if (title.startsWith("-"))
                        title = title.replaceFirst("-", "").trim();
                }
            }
        } catch (Exception e) {
            return humanizeTitle(title);
        }
        return humanizeTitle(title);
    }

    /**
     * This will remove all kind of multiple escape characters from String. -> [\r\n\t\f\v ]
     */
    private static String removeUnwantedSpaces(String value) {
        value = value.trim().replaceAll(REGEX_WHITESPACE_CHARACTERS, " ");
        return value;
    }

    private static boolean isSentenceStopper(String singleCharacter) {
        Pattern pattern = Pattern.compile(REGEX_SPACIAL_CHAR_FOR_AVOID_SPACE);
        Matcher matcher = pattern.matcher(singleCharacter);
        return matcher.matches();
    }

    @Deprecated
    private static boolean isSpecialCharacter(String singleCharacter) {
        Pattern pattern = Pattern.compile(REGEX_SPACIAL_CHAR_IN_FIST_PLACE);
        Matcher matcher = pattern.matcher(singleCharacter);
        return !matcher.matches();
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TITLE_CAPS, TITLE, SENTENCE})
    private @interface HumanizerTextTypes {
    }
}
