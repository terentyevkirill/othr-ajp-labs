package game.dsl;

public class BasicPlayer implements Player {
    private final String name;
    private boolean isMaster;

    public BasicPlayer(String name) {
        this.name = name;
    }

    public BasicPlayer(String name, boolean isMaster) {
        this.name = name;
        this.isMaster = isMaster;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isMaster() {
        return isMaster;
    }

    @Override
    public void setMaster(boolean isMaster) {
        this.isMaster = isMaster;
    }

    @Override
    public String toString() {
        return isMaster ? name + " (master)" : name;
    }
}
