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



## JIT

#### Compilation unit

**method-based** JIT. Reason:

- block-based: too detailed. And JNI overhead will let a block-based JIT **very very slow**
- loop-based: a good idea, but the OSR(OnStackReplacement) is too anonying.
  - I want to implement: when running `for (int i=1; i<=n; ++i)` , if the counter >= 1000, JIT and **execute it immediately**. 
    (Because usually, you will not pass a loop twice unless it is in a hot function or in another loop.)
  - If I just need to implement: JIT the hot loop, and **execute it next time I meet it**, 
    a good idea is that the compiler wraps the loop as a function (with liveIn as input and liveOut as return)
  - And maybe I should rewrite my AsmBuilder.
- trace-based: it is too hard to analysis.

And method-based has some advantage:

- Easy to implement. A function is a unit with good isolation of memory. The interpreter just needs to follow the calling convention, 
  passes the arguments and get the return value correctly. (Still there are some problems).
- Many of my optimizations are FuncPass. I can direcly apply them to my JIT compiled code.
- The AsmBuilder I use in Masterball can be easily modifed to compile one function.



#### JIT Constraint

Still there are some functions that can not be JIT compiled. There are mainly three types:

- Has libc malloc call. This is the VM has its own memory management scheme, and if I let ravel to execute `malloc` , I can not sure if the allocation is valid.

- ~~Has global value store. This is because the global value in assembly is a symbol (the address is decided by ravel.)
  This can be fixed by adding some instructions when quitting from ravel. (load them to register)~~

  Fixed, but I use some hacking tricks... (by restoring them to a1~a9 registers.)
  
- Has call whose caller has not been compiled.

  This means my JIT can only deal with a CallGraph without cycle. 
  Each time I will do dependency analysis, and compile the function **if all its callees are compiled.**



#### JIT Schedule

It is very simple now. 

- When t**he running time (number of instructions) reaches certain THRESHOLD**, give a signal to FuncProfiler.
- The profiler select a hottest function and submit it to JIT Compiler.
- The compiler compiles it and submit to CodeGenerator (with a code storage).



