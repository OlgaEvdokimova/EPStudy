package String2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements Serializable {
    private static final long serialVersionUID = 1;
    String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
        breakIntoWords(sentence);
    }

    public List<Word> words() {
        List<Word> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^\\s]+");
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            String matcherWord = matcher.group();
            Word word = new Word(matcherWord);
            words.add(word);
        }
        return words;
    }

    public void breakIntoWords(String partOfSentence) {
        Pattern pattern = Pattern.compile("[^\\s]+");
        Matcher matcher = pattern.matcher(partOfSentence);
        while (matcher.find()) {
            String matcherWord = matcher.group();
            Word word = new Word(matcherWord);
            words().add(word);
        }

    }

    public void deleteSubstring(String firstSymbol, String lastSymbol) {
        if (sentence.contains(".") && (sentence.contains(firstSymbol)) && (sentence.contains(lastSymbol))) {
            int indexLast = sentence.lastIndexOf(lastSymbol);
            int indexFirst = sentence.indexOf(firstSymbol);
            if (indexFirst < indexLast) {
                sentence.substring(0, indexFirst).concat(sentence.substring(indexLast + 1));

            }
            if (indexFirst > indexLast) {
                sentence.substring(0, indexLast).concat(sentence.substring(indexFirst + 1));

            }
        }
    }

    public void replaceFirstWordAndTheLastWordInExclamatorySentences() {
        if (sentence.endsWith("!")) {
            Word temp = words().get(0);
            words().set(0, words().get(words().size() - 1));
            words().set((words().size() - 1), temp);
        }
    }

    public boolean containsWord(Word word) {
        return words().contains(word);
        // or return sentence.contains(word); // String word
    }


    @Override
    public String toString() {
        return sentence;
    }

    @Override
    public boolean equals(Object obj) {
        return sentence.equals(obj);
    }

    @Override
    public int hashCode() {
        return sentence.hashCode();
    }
}


//List<Word> words = new ArrayList<>();