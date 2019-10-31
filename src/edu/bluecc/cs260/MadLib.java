package edu.bluecc.cs260;

import edu.princeton.stlib.StdIn;

//http://www.madtakes.com/printglib.php?glibid=1

public class MadLib {

  public static void main(String[] args) {
    MadLib madLib = new MadLib("In the book War of the [1], the main character is an anonymous [2] who records the arrival of [3] in [4]. Needless to say, havoc reigns as the [3] continue to [5] everything in sight, until they are killed by the common [6].",
        new String[]{"NOUN (PLURAL)","OCCUPATION", "ANIMAL (PLURAL)", "PLACE", "VERB", "NOUN"});
    play(madLib);
  }

  public static void play(MadLib madLib) {
    String[] words = getWords(madLib.getParts());
    String story = generate(madLib.getText(), words);
    System.out.println(story);
//    System.out.println(read(madLib.getText(),getWords(madLib.getParts())));
  }

  private static String[] getWords(String[] parts) {
    String[] words = new String[parts.length];
    for (int i = 0; i < parts.length; i++) {
      System.out.print(String.format("Give me a %s: ", parts[i]));
      words[i] = StdIn.readLine();
    }
    return words;
  }

  private static String generate(String text, String[] words) {
    String s = text;
    for (int i = 0; i < words.length; i++)
      s = s.replaceAll("\\["+(i+1)+"\\]",words[i]);
    return s;
  }

  private String text;
  private String[] parts;

  public MadLib(String text, String[] parts) {
    this.text = text;
    this.parts = parts;
  }

  public String getText() {
    return text;
  }

  public String[] getParts() {
    return parts;
  }
}