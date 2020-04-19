package game.dsl;

public class BasicPlayer implements Player {
    private String name;
    private boolean isMaster;
    private int age;
    private int level;

    public BasicPlayer() {
        this.name = "Ivan";
    }

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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
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
        StringBuilder sb = new StringBuilder();
        sb.append("{ name: ").append(name);
        if (this.age > 0)
            sb.append(", age: ").append(age);
        if (this.level > 0)
            sb.append(", level: ").append(level);
        if (this.isMaster)
            sb.append(" (master)");
        sb.append(" }");
        return sb.toString();
    }
}
