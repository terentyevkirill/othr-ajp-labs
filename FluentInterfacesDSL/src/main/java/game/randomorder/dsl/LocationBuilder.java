package game.randomorder.dsl;

public interface LocationBuilder extends GameBuilderTerminator {
    SemiInterface setInSpace();
    SemiInterface setOnEarth();
    SemiInterface setUnderwater();
}
