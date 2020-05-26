package com.github.savitoh;

import java.util.Arrays;

/**
 * You probably know the "like" system from Facebook and other pages. People can
 * "like" blog posts, pictures or other items. We want to create the text that
 * should be displayed next to such an item.
 *
 * Implement a function likes :: [String] -> String, which must take in input
 * array, containing the names of people who like an item. It must return the
 * display text as shown in the examples:
 *
 * likes {} // must be "no one likes this" likes {"Peter"} // must be "Peter
 * likes this" likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
 * likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this" likes
 * {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like
 * this" For 4 or more names, the number in and 2 others simply increases.
 */

public class WhoLikesIt {

    private static final String SYMBOL_DELIMITER = ", ";

    private static final long LIMIT_QUANTITY_NAMES_PRESENT_SENTENCE = 3;

    private static final short LIMIT_QUANTITY_NAMES_PRESENT_SENTENCE_WHEN_MORE_THAN_FOUR_INPUT_NAMES = 2;

    public static String solution(String... names) {
        final int lenghtVectorNames = names.length;
        return Arrays.stream(names)
            .limit(LIMIT_QUANTITY_NAMES_PRESENT_SENTENCE)
            .reduce((firstName, secondName) -> firstName + SYMBOL_DELIMITER + secondName)
            .map(namesConcatsWithDelimiter -> {
                if(lenghtVectorNames > 3) {
                    return formatSentenceWithMoreThanThreeName(namesConcatsWithDelimiter, lenghtVectorNames);
                }
                return formatSentence(namesConcatsWithDelimiter);
            })
            .orElse("no one likes this");
    }

    private static String formatSentenceWithMoreThanThreeName(
            final String namesConcatsWithDelimiter, int amountNameInputs) {        
        int amountNamesRemaining = 
            amountNameInputs - LIMIT_QUANTITY_NAMES_PRESENT_SENTENCE_WHEN_MORE_THAN_FOUR_INPUT_NAMES;
        final String subStringBeforeSymbolDelimiter = getSubStringBeforeSymbolDelimiter(namesConcatsWithDelimiter, SYMBOL_DELIMITER);
        final String endString = String.format(" and %d others like this", amountNamesRemaining);
        return subStringBeforeSymbolDelimiter.concat(endString);
    }

    private static String formatSentence(String namesConcatsWithDelimiter) {
        if(namesConcatsWithDelimiter.contains(SYMBOL_DELIMITER)) {
            int lastDelimiterOccurrence = namesConcatsWithDelimiter.lastIndexOf(SYMBOL_DELIMITER);
            final String subStringBeforeSymbolDelimiter = 
                getSubStringBeforeSymbolDelimiter(namesConcatsWithDelimiter, SYMBOL_DELIMITER);
            final String replacedDelimiter = 
                namesConcatsWithDelimiter.substring(lastDelimiterOccurrence).replace(SYMBOL_DELIMITER, " and ");
            return subStringBeforeSymbolDelimiter + replacedDelimiter + " like this";
        }
        return namesConcatsWithDelimiter.concat(" likes this");
    }

    private static String getSubStringBeforeSymbolDelimiter(final String str, final String symbolDelimter) {
        int lastDelimiterOccurrence = str.lastIndexOf(symbolDelimter);
        return str.substring(0, lastDelimiterOccurrence);
    }


}
