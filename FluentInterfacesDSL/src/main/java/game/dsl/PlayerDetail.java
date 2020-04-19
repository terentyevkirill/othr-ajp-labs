package game.dsl;

public class PlayerDetail<A> {

    public enum PlayerDetailType {NAME, AGE, LEVEL;}

    protected final PlayerDetailType attributeType;
    private final A attribute;

    public PlayerDetail(A attribute, PlayerDetailType attributeType) {
        this.attribute = attribute;
        this.attributeType = attributeType;
    }

    public static <B> PlayerDetail<B> newInstance(B attribute, PlayerDetailType attributeType) {
        return new PlayerDetail<>(attribute, attributeType);
    }

    protected A getAttribute() {
        return attribute;
    }
}
