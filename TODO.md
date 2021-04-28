# A clean todo TODO :D

* versione dove il presenter è l'observable
  - `AddTodoViewModel` espone tutti i dati in maniera public anche in modifica
* versione dove il presenter delega l'observable ad una sua componente
* verificare la testabilità
  - che "faccia" avrebbe un test?
* versione servlet
* versione spark

## domande / dubbi / riflessioni

* qual'è il senso del controller? (joe)
  - Ha senso il controller? è quasi un man-in-the-middle...
* come testo la parte web? (joe)
* un solo presenter oppure piu' presenter?
* ma il modulo che contiene il controller contiene solo il controller?
* `AddTodoUseCase` non dovrebbe essere public

