
public class FirstDSLExample {
    public static void main(String[] args) {
        StartIF start = new Builder();
        start.singleWord().end();
        start.parametrizedWord("Hello world!").end();
        start.word1().end();
        start.word1().optionalWord().end();
        start.word2().wordChoiceA().end();
        start.word2().wordChoiceB().end();
        start.word3().end();
        start.word3().word3().end();
        start.word3().word3().word3().end();
    }
}
