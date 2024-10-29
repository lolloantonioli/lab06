# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git -> cd OOp-git-merge-conflict-test

2. Ci si assicuri di avere localmente entrambi i branch remoti
git log --all --graph
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
git merge origin/feature
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
Modifico il file su VSCode -> git add HelloWorld.java -> git commit -m "Modificato HelloWorld.java per merge conflict"
6. Si crei un nuovo repository nel proprio github personale
Lo creo su GitHub
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
git remote add test https://github.com/lolloantonioli/test.git
8. Si faccia push del branch `master` sul proprio repository
git push test
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
git branch --set-upstream-to=test/master
