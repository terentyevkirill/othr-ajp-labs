# "Recursive" Grammar

Allows recursive adding of `Game` objects to the current `Game` object. (`Game`s are now supposed to be played against other `Game`s (adversaries))


## Grammar diagram

![Recursive Grammar](Recursive.jpg)

## Code snippet

````java

import static game.Game.*;

// ...

Game g = Game.create()
             .player( name("Brent"), age(27), level(3) )
             .player( name("Sue"), level(10) )
             .setOnEarth()
             .player( name("Mary") ).asMaster()
             .player( )
             .adversary(Game.create()
                            .player( name("Capt. Kirk"), age(99))
                            .setInSpace()
                            .player( name("Kahn") )
                            .adversary(Game.create()
                                           .player( level(1000)  )
                                           .get())
                            .get())
             .get();




````
