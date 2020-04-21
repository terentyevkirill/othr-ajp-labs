package game.randomorder.dsl;

public interface Player {
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    int getLevel();
    void setLevel(int level);
    boolean isMaster();
    void setMaster(boolean isMaster);
}
