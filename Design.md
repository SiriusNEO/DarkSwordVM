# Design



## Interpreter

- Parser：antlr4, char stream -> context
- Module Builder: context -> internal structure (masterball)
- Machine Booting: load global variable & global str
- Interpreter: run on Machine, interpret block by block



## Machine

- curBlock: current running block.

  is it necessary to storage all code？No.

- register storage

  ```
  Value -> int
  ```

  why int？

  Because our LLVM IR is not complete.

  Main types:

  - i32: stored as number
  - i1/i8: stored as 0/1, also as int
  - str/global variable/array: all these are **address**, stored as int
  - `[4 x i32]`  ArrayType only in str, stored in memory (bss)

- memory

  ```
  addr -> byte
  ```

  simulate true memory.