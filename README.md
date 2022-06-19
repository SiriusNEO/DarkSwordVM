# DarkSword VM

<div align="center">
	<img src="asset/darksword.png" height="200" width="200" />
</div>



a virtual machine with interpreter and just-in-time compilation for LLVM IR.

Machine Code: RV32I, running in ravel.



![](https://img.shields.io/badge/build-passing-success)   ![](https://img.shields.io/badge/Interpreter-passing-success)   ![](https://img.shields.io/badge/JIT-passing-success)



## Design

```mermaid
graph LR
A[src: .ll file]
B[ParseTree]
C[Running IR]
D[Compiling IR]
E[Interpreter]
F[JIT Compiler]
G[Profiler]
H[Machine]
I[Ravel]
J[CodeGenerator]
K[JITScheduler]
subgraph Parser
    A ==Antlr v4==> B
    B ==ModuleBuilder2==>D
    B ==ModuleBuilder1==>C
end
    C ==booting==> H
    D ====> F
    E ==Running On==>H

subgraph Core
    F ==compiled assembly==> E
    E ==compile request==> F
    H ==ravel call==> I
    I ==execute result==> H
    E ==running info==>G
    G ==hot select==> E
    E ==compiled assembly==> J
    J ==get code==> E
    K ==signal of JIT==> E
end
```





## Usage

This project is attached to [Masterball](https://github.com/SiriusNEO/Masterball) Compiler.

1. Drag the directory `darksword` into the `src` directory in [Masterball](https://github.com/SiriusNEO/Masterball). and run `DarkSwordVM` .
2. Build the artifact with `DarkSwordVM.java` as the main class.
3. Run `java -jar DarkSword.jar -h` to get the help doc.

If you want to try the `JIT` part, a RISCV simulator [ravel](https://github.com/Engineev/ravel) is required to execute the RISCV Assembly (machine code).

4. Get the library in `lib/ravel/libravel-sim.so` (which is a specially designed ravel for DSVM.)

5. Run DarkSword with arguments: `-jit` `-ravel <the absolute path of libravel-sim.so>` 

6. If the `connect` is OK when initialization, DarkSword will receive a ACK:

   ```
   [ravel] Connecting to DarkSword... Success. Test Word: Hello, ravel
   ```

   

## TODO

- [x] Interpreter (`Masterball FrontEnd + DarkSword Interpreter` passed all codegen testcases.)
- [x] Simple JIT (method-based or BB-based...), context switch between JIT and Interpreter
- [x] JIT Optimization (Reuse Static)
- [ ] Use runtime information



## Ravel 

- [x] Ravel will set `sp` to the end of the storage. (Fixed)
- [x] Ravel (x86) mem uses small-endian but DarkSword uses big-endian. (Fixed)
- [x] Ravel can not link `builtin.s` therefore I can not JIT codes with libc call. (Fixed, but...)
- [x] Ravel can not pass Global Value (Fixed, but...)
- [x] Ravel use `fopen('w')` and the file `test.out` will be cleared every time `simulate` is called. (Fixed)