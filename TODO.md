# A clean todo TODO :D

* Provare a scrivere una "Testing API" sulla Clean ToDo App
* Provare nella "clean-todo" un esempio di full-fledged architectural boundary e one-dimensional boundary per la parte di persistenza
* Provare arch-unit nella "clean-todo" app

* versione servlet
  * se devo leggere un pay  come cambia il codice della versione servlet?
  - e se devo restituire JSON?
  - cosa cambia? => abbiamo dovuto specificare una view diversa, tutto il resto è stato riusato
  - cosa dobbiamo aggiungere? => la view html e la TodoServlet
  - dovremo fare un nuovo presenter? veramente il presenter rimane uno solo a prescindere dal tipo di meccanismo di visualizzazione dell'output? => dipende dal view model... se cambia il view model, cambia il presenter

* provare la versione in cui il presenter è un collaboratore del controller e non dello use case
* gestire il null message nel Controller?
* supportare la localizzazione dei messaggi per la view
* restringere la visibilità di `AddTodoUseCase`: non dovrebbe essere public
* verificare la testabilità
  - che "faccia" avrebbe un test?
  - come testiamo il presenter?
* versione con i moduli separati esplicitamente
* versione spark
* cosa succede se volessimo adottare GraphQL? (query model complesso...)
  - come e dove dovremmo agire?


## domande / dubbi / riflessioni

* qual è il senso del controller? (joe)
  - Ha senso il controller? è quasi un man-in-the-middle...
* come testo la parte web? (joe)
* usiamo un solo ViewModel per la stessa View? (joe)
* ma il modulo che contiene il controller contiene solo il controller? 
* se separiamo in moduli distinti le app del “clean todo”, potremo avere anche diversi build.gradle con diverse dipendenze (ad es la console app non ha bisogno di spark o delle servlet)
* il fatto che il controller sia solo veicolo di input verso l'applicazione ma non si occupi dell'output è legato al principio di separazione tra comandi e query?
  - in [questa risposta](https://softwareengineering.stackexchange.com/questions/357052/clean-architecture-use-case-containing-the-presenter-or-returning-data) lo collegano al CQRS... ha senso?
