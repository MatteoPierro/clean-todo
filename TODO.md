# A clean todo TODO :D

* supportare la localizzazione dei messaggi per la view
* versione dove il presenter delega l'observable ad una sua componente (invece di estendere lui observable)
* restringere la visibilità di `AddTodoUseCase`: non dovrebbe essere public
* verificare la testabilità
  - che "faccia" avrebbe un test?
  - come testiamo il presenter?
* versione servlet
  - cosa cambia?
  - cosa dobbiamo aggiungere?
  - dovremo fare un nuovo presenter? veramente il presenter rimane uno solo a prescindere dal tipo di meccanismo di visualizzazione dell'output?
* versione con i moduli separati esplicitamente
* versione spark

## domande / dubbi / riflessioni

* qual'è il senso del controller? (joe)
  - Ha senso il controller? è quasi un man-in-the-middle...
* come testo la parte web? (joe)
* usiamo un solo ViewModel per la stessa View? (joe)
* un solo presenter oppure piu' presenter?
* ma il modulo che contiene il controller contiene solo il controller? 
* se separiamo in moduli distinti le app del “clean todo”, potremo avere anche diversi build.gradle con diverse dipendenze (ad es la console app non ha bisogno di spark o delle servlet)
* il fatto che il controller sia solo veicolo di input verso l'applicazione ma non si occupi dell'output è legato al principio di separazione tra comandi e query?
  - in [questa risposta](https://softwareengineering.stackexchange.com/questions/357052/clean-architecture-use-case-containing-the-presenter-or-returning-data) lo collegano al CQRS... ha senso?
