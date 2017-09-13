# SymbolTableGenerator
A basic symbol table generator for semantic analysis stage of the compiler using Java.
Rub **SymbolTable.java** and enter inputs accordingly to generate the symbol table structure.

Functions provided-

  **insert(name,kind,type)**: inserts an entry for x in the current scope if it is already not defined in it. Throws an error if the variable name is already present in the most recent scope.
  
  **lookup(name)**: returns the most recent definition of name by searching the tree from leaf to root.If no match is found it throws an error.
  
  **enter_scope()**: Generates a new level of nesting by creating a symbol table for the new scope.
  
  **exit_scope()**: remove symbol table entries for the current scope and move back to the enclosing scope in the symbol table tree.
