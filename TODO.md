# A clean todo TODO :D

* provare a visualizzare il colore del TODO nella console: cosa dobbiamo modificare?
* versione dove il presenter è l'observable
  - `AddTodoViewModel` espone tutti i dati in maniera public anche in modifica
  - pro: 
    - il presenter non ha più stato,
    - il wiring è leggermente più semplice (niente dettaglio sul viewmodel)
* versione dove il presenter delega l'observable ad una sua componente
* restringere la visibilità di `AddTodoUseCase`: non dovrebbe essere public
* verificare la testabilità
  - che "faccia" avrebbe un test?
* versione servlet
  - cosa cambia?
  - cosa dobbiamo aggiungere?
  - dovremo fare un nuovo presenter?
* versione con i moduli separati esplicitamente
* versione spark

## domande / dubbi / riflessioni

* qual'è il senso del controller? (joe)
  - Ha senso il controller? è quasi un man-in-the-middle...
* come testo la parte web? (joe)
* un solo presenter oppure piu' presenter?
* ma il modulo che contiene il controller contiene solo il controller?

