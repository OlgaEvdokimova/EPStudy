package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text implements Serializable {
    private static final long serialVersionUID = 1;
    List<Sentence> sentences = new ArrayList<>();

    // Constructor for reading file
    public Text(File file) {
        this(Reader.readIntoString(file));
    }

    /**
     * Constructor if text is String
     *
     * @param wholeText is a string of whole text
     */
    public Text(String wholeText) {
        setText(wholeText);
    }

    public void setText(String wholeText) {
        sentences.clear();
        appendSentence(wholeText);
    }

    /**
     * method for split text into sentences
     *
     * @param wholeText is the string-text
     *                  find each sentence, create new Sentence, add new Sentence to the list sentences
     */
    public void appendSentence(String wholeText) {
        Pattern pattern = Pattern.compile("[^!.?]+[\\.\\!\\?]+");
        Matcher matcher = pattern.matcher(wholeText);
        while (matcher.find()) {
            String matcherSentence = matcher.group().trim();
            Sentence sentence = new Sentence(matcherSentence);
            sentences.add(sentence);
        }
    }

    /**
     * listForWords is a list to be put notRepeatedWords into it
     */
    public void findNoRepeatedWordsInFirstSentenceOfText() {
        HashSet<Word> set = new HashSet<>(sentences.get(0).words());
        Iterator<Word> i = set.iterator();
        List<Word> listForWords = new ArrayList<>();
        int count;
        while (i.hasNext()) {
            Word elementOfSet = i.next();
            count = 0;
            for (int k = 1; k < sentences.size(); k++) {
                List<Word> words = sentences.get(k).words();
                for (Word notRepeatedWord : words) {
                    if (elementOfSet.toString().equals(notRepeatedWord.toString())) {
                        count++;
                        break;
                    }
                }
            }
            if (count == 0) {
                listForWords.add(elementOfSet);
            }
            StringBuilder sentence = new StringBuilder();
            for (Word w : listForWords) {
                sentence.append(w.word.concat(" "));
            }
            sentences.set(0, new Sentence(sentence.toString()));
        }
    }


    public void replaceFirstWordAndTheLastWordInExclamatorySentences() {

        for (int i = 0; i < sentences.size(); i++) {
            if (sentences.get(i).sentence.endsWith("!")) {
                List<Word> words = sentences.get(i).words();
                Collections.swap(words, 0, words.size() - 1);
                StringBuilder sentence = new StringBuilder();
                for (Word w : words) {
                    sentence.append(w.word.concat(" "));
                }
                sentences.set(i, new Sentence(sentence.toString()));
//                Word temp = wordsOfString.get(0);
//                wordsOfString.set(0, wordsOfString.get(wordsOfString.size() - 1));
//                wordsOfString.set((wordsOfString.size() - 1), temp);
            }
        }

    }


    public void findAndDeleteFirstLetter() {
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < sentences.size(); i++) {
            if (sentences.get(i).sentence.contains("?")) {
                List<Word> words = sentences.get(i).words();
                for (int j = 0; j < words.size(); j++) {
                    String firstSymbol = words.get(j).letters.get(0).symbol;
                    for (int k = words.get(j).letters.size() - 1; k >= 0; k--) {
                        if (k == 0) {
                            break;
                        } else if (words.get(j).letters.get(k).symbol.compareToIgnoreCase(firstSymbol) == 0) {
                            words.get(j).letters.remove(k);
                        }
                    }
                    StringBuilder newListOfLetters = new StringBuilder();
                    for (Letter l : words.get(j).letters) {
                        newListOfLetters.append(l.symbol);
                    }
                    words.set(j, new Word(newListOfLetters.toString()));
                    sentence.append(words.get(j).word.concat(" "));
                }
                sentences.set(i, new Sentence(sentence.toString()));

            }

        }
    }

    public void deleteSubstring(String firstSymbol, String lastSymbol) {
        firstSymbol = firstSymbol.toLowerCase();
        lastSymbol = lastSymbol.toLowerCase();
        for (Sentence sentence : sentences) {
            sentence.sentence = sentence.sentence.toLowerCase();
            if (sentence.sentence.contains(".") && (sentence.sentence.contains(firstSymbol)) && (sentence.sentence.contains(lastSymbol))) {
                int indexLast = sentence.sentence.lastIndexOf(lastSymbol);
                int indexFirst = sentence.sentence.indexOf(firstSymbol);
                if (indexFirst < indexLast) {
                    System.out.println(sentences.indexOf(sentence));
                    System.out.println(indexFirst);
                    System.out.println(indexLast);
                    sentences.set(sentences.indexOf(sentence), new Sentence(sentence.sentence.substring(0, indexFirst).
                            concat(sentence.sentence.substring(indexLast + 1))));
                }
                if (indexFirst > indexLast) {
                    sentences.set(sentences.indexOf(sentence), new Sentence(sentence.sentence.substring(0, indexLast).
                            concat(sentence.sentence.substring(indexFirst + 1))));
                }
            }
        }
    }


}



