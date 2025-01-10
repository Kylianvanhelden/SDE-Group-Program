# SDE-Group-Program
repo: [SDE-Group-Program](https://github.com/Kylianvanhelden/SDE-Group-Program)

Contributers:

Kylian van Helden: [Kylianvanhelden](https://github.com/KylianvanHelden)

Atilla Özbey: [AtillaOzbey](https://github.com/AtillaOzbey)

In de commit History is te zien dat Kylian meer commits heeft gedaan, maar Atilla heeft al zijn code in een paar hele grote commits gedaan, ook hebben we samen naast elkaar aan dingen gewerkt op één computer en dingen besproken

## Design Patterns:
### Creational Patterns:
#### Singleton
    Wij hebben de singleton geïmplementeerd in Board.java.
    Er kan in één spel namelijk maar één board bestaan
    Deze singleton wordt aangeroepen in een van de GameTemplate files (CheckersGame.java of CheckersGameSize8.java in dit geval).


### Structural Patterns:
#### Bridge
    De Bridge is geïmplementeerd in ConsoleRenderer.java, Renderer.java en RendererBridge.java.

    In onze app is Renderer.java de Implementation, RendererBridge.java de Abstraction en ConsoleRenderer.java de Concrete Implementation.

    In Checkers.java (Main.java) wordt een RendererBridge aangemaakt met ConsoleRenderer als renderer, dit zorgt ervoor dat in de console een spel gemaakt wordt. 
    
    Als je een spel buiten de console wil maken kan dat als een Concrete Implementation toegevoegd worden en als parameter meegegeven worden.

#### Proxy
    De proxy is geïmplementeerd in Move.java, MoveProxy.java en MoveValidator.java.

    in onze app is Move.java de interface, MoveValidator de Service en MoveProxy de proxy.

    MoveValidator.java kijkt of de move die je probeert te maken correct is, MoveProxy breidt dit uit door ook te kijken of het stuk dat verplaats moet worden correct is, dit door te geven aan Board.java en geeft een foutmelding als dit niet het geval is.

### Behavioral Patterns:
#### State
    De state is geïmplementeerd in de State.java, WhitePlays.java, BlackPlays.java en PlayerTurn.java files
    
    In onze app is State.js de state, PlayerTurn.java de de context en WhitePlays.java en BlackPlays.java de concrete states

    Op het moment dat je in het spel een beurt correct uitvoert zal de state veranderen en op het moment dat het spel voorbei is zal de correcte state een victorie message geven

#### Template
    De template wordt geïmplementeerd in GameTemplate.java, CheckersGame.java en CheckersGameSize8.java.

    in onze app is de GameTemplate de abstract class en CheckersGame.java en CheckersGameSize8.java de concrete classes.

    In de template zijn er 4 verschillende abstract classes die per concrete class kunnen verschillen, bijvoorbeeld wie het spel start en hoe het spel eindigt, ook kan je de grote van het board aanpassen hier.
