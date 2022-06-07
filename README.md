# DarkSword VM

<div align="center">
	<img src="asset/darksword.png" height="200" width="200" />
</div>



a virtual machine with interpreter and just-in-time compilation for LLVM IR.

Machine Code: RV32I, running in ravel.



## Usage

This project is attached to [Masterball](https://github.com/SiriusNEO/Masterball) Compiler.

Drag the directory `darksword` into the `src` directory in [Masterball](https://github.com/SiriusNEO/Masterball). and run `DarkSwordVM` .



## TODO

- [x] Interpreter (`Masterball FrontEnd + DarkSword Interpreter` passed all codegen testcases.)
- [x] Simple JIT (method-based or BB-based...), context switch between JIT and Interpreter
- [x] JIT Optimization (Reuse Static)
- [ ] Use runtime information



## Ravel 

- [x] Ravel will set `sp` to the end of the storage. (Fixed)
- [x] Ravel (x86) mem uses small-endian but DarkSword uses big-endian. (Fixed)
- [ ] Ravel can not link `builtin.s` therefore I can not JIT codes with libc call.
- [ ] Ravel can not pass Global Value