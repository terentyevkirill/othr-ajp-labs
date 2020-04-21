# "Nested" Grammar

Now lets slightly change how `Player`s’ attributes are added. 
See the following syntax diagram and code snippet in order to change your implementation.

## Grammar diagram

![Nested Grammar](Nested.jpg)

## Code snippet

````java

import static game.Game.*;

// ...

Game g = Game.create()
             .player( name("Brent"), age(27), level(3) )
              .player( name("Sue"), level(10) )
              .player( name("Mary") ).asMaster()
              .player()
              .setUnderwater();


````
