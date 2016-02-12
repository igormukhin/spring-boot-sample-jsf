package org.acme.sample.predicateeditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by igor.mukhin on 12.02.2016.
 */
public class PredicateEditorUtils {

    public static List<String> inputTextToStringList(String inputText) {
        inputText = (inputText == null ? "" : inputText);
        return new ArrayList<String>(Arrays.asList(inputText.split("\\s*;\\s*")));
    }

    public static String stringListToInputText(List<String> values) {
        return values.stream().collect(Collectors.joining("; "));
    }

}
