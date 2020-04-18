public interface StartIF extends SingleWordIF, ParametrizedWordIF, Word1IF, Word2IF, Word3IF {
}
interface SingleWordIF {
    EndIF singleWord();
}
interface ParametrizedWordIF {
    EndIF parametrizedWord(String parameter);
}
interface Word1IF {
    EndOrOptionalWordIF word1();
}
interface Word2IF {
    WordChoiceAAndBIF word2();
}
interface Word3IF {
    Word3OrEndIF word3();
}
interface EndIF {
    void end();
}
interface OptionalWordIF {
    EndIF optionalWord();
}
interface WordChoiceAAndBIF {
    EndIF wordChoiceA();
    EndIF wordChoiceB();
}
interface Word3OrEndIF extends EndIF {
    Word3OrEndIF word3();
}
interface EndOrOptionalWordIF extends EndIF, OptionalWordIF {
}
