public class Builder implements StartIF {
    private BuilderContainer container = new BuilderContainer();

    public EndIF singleWord() {
        container.buffer.append(".singleWord()");
        return container;
    }

    @Override
    public EndIF parametrizedWord(String parameter) {
        container.buffer.append(".parametrizedWord(").append(parameter).append(")");
        return container;
    }

    @Override
    public EndOrOptionalWordIF word1() {
        container.buffer.append(".word1()");
        return container;
    }

    @Override
    public WordChoiceAAndBIF word2() {
        container.buffer.append(".word2()");
        return container;
    }

    @Override
    public Word3OrEndIF word3() {
        container.buffer.append(".word3()");
        return container;
    }

    class BuilderContainer implements EndIF, EndOrOptionalWordIF, WordChoiceAAndBIF, Word3OrEndIF {
        StringBuffer buffer = new StringBuffer();

        BuilderContainer() {
            buffer.append("start()");
        }

        @Override
        public void end() {
            buffer.append(".end()");
            System.out.println(buffer.toString());
            buffer = new StringBuffer();
            buffer.append("start()");
        }

        @Override
        public EndIF optionalWord() {
            buffer.append(".optionalWord()");
            return this;
        }

        @Override
        public EndIF wordChoiceA() {
            buffer.append(".wordChoiceA()");
            return this;
        }

        @Override
        public EndIF wordChoiceB() {
            buffer.append(".wordChoiceB()");
            return this;
        }

        @Override
        public Word3OrEndIF word3() {
            buffer.append(".word3()");
            return this;
        }
    }
}
