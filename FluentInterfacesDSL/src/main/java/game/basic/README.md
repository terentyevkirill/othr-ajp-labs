# "Basic" Grammar

Basic internal DSL style implemented. Game creation is now performed in fluent style with Builder pattern. 

## Grammar diagram

![Basic Grammar](Basic.jpg)

## Code snippet

````java


// ...

Game g = Game.create()
             .player("Tom")
             .player("Annie")
             .asMaster()
             .player("Louise")
             .setInSpace();

````
