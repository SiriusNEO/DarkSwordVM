grammar LLVMIR;

// Add Package Automatically
@header {
    package darksword.interpreter.generated;
}

rootLLVMIR: (targetInfo | funcDecl | funcDef | globalDecl | classDecl)* EOF;

// target info
targetInfo: sourceFn | dataLayout | targetTriple;
sourceFn: 'source_filename' '=' InfoStr;
dataLayout: 'target' 'datalayout' '=' InfoStr;
targetTriple: 'target' 'triple' '=' InfoStr;

// globalDecl
initExp: (atom | 'zeroinitializer');
globalDecl: GlobalReg '=' LinkageType? PreemptionSpecifiers? VisibilityStyles? UnnamedAddr? GlobalWord type initExp alignment?;

// class
classDecl: LocalReg '=' 'type' '{' (type (',' type)*)? '}';

// function
funcCall:  ParaAttr? type GlobalReg '(' (type atom? (',' type atom?)*)? ')';
funcInfo:  LinkageType? PreemptionSpecifiers? VisibilityStyles? type
           GlobalReg '(' (type LocalReg? (',' type LocalReg?)*)? ')'
           UnnamedAddr? FuncAttr?;
funcDecl: 'declare' funcInfo ;
funcDef: 'define' funcInfo '{' (basicBlock)* '}';

// block
basicBlock: Identifier ':' (instruction)*;

// inst
instDest: LocalReg '=';

gepOffset: ',' type atom;
phiBranch: '[' atom ',' atom ']';
cmpOp: 'sgt' | 'sge' | 'slt' | 'sle' | 'eq' | 'ne';
binaryOp: 'add' | 'sub' | 'mul' | 'sdiv' | 'srem' | 'shl' | 'ashr' | 'and' | 'or' | 'xor';

instruction
    :   instDest 'alloca' type alignment?                            #alloca
    |   instDest binaryOp type (lsrc = atom) ',' (rsrc = atom)       #binary
    |   instDest 'bitcast' type (src = atom) 'to' type           #bitcast
    |   instDest 'trunc'   type (src = atom) 'to' type               #trunc
    |   instDest 'zext'    type (src = atom) 'to' type               #zext
    |   'br' type (src = atom) ',' type atom ',' type atom           #br
    |   'br' type atom                                               #br
    |   instDest? 'call' funcCall                                    #call
    |   instDest 'getelementptr' 'inbounds'?
        type ',' type (src = atom) (gepOffset)*                      #getelementptr
    |   instDest 'icmp' cmpOp type (lsrc = atom) ',' (rsrc = atom)   #icmp
    |   instDest 'load'  type ',' type atom alignment?               #load
    |   'store' type atom ',' type atom alignment?                   #store
    |   'ret' type (atom)?                                           #ret
    |   instDest 'phi' type phiBranch (',' phiBranch)*               #phi
    ;

// atom
atom:  integerConstant | StringConstant | NullptrConstant | BoolConstant | GlobalReg | LocalReg;

// align
alignment: ',' 'align' IntegerLiteral;

// type
type: type (pointer = '*') | basicType | arrayType;
arrayType: '[' (arrayLen = IntegerLiteral) 'x' type ']';
basicType: IntType | VoidType | LabelType | LocalReg; // struct type

IntType: 'i' IntegerLiteral;
VoidType: 'void';
LabelType: 'label';

// register
GlobalReg: '@' Identifier;
LocalReg: '%' Identifier;

// constant
integerConstant: IntegerLiteral | '-' IntegerLiteral;
NullptrConstant: 'null';
BoolConstant: 'true' | 'false';
StringConstant
    :   'c"' (EscapeEnter | EscapeBackslash | EscapeQuote | StringLiteral)*? EndZero '"'
    ;

// llvm. ref: https://llvm.org/docs/LangRef.html

LinkageType: 'private' | 'common' | 'internal' | 'external';
PreemptionSpecifiers: 'dso_preemptable' | 'dso_local';
VisibilityStyles: 'default' | 'hidden' | 'protected';
GlobalWord: 'global' | 'constant';
UnnamedAddr: 'unnamed_addr' | 'local_unnamed_addr';
FuncAttr: 'nounwind';
ParaAttr: 'noalias';

// basic
IntegerLiteral: '0' | [1-9][0-9]*;
Identifier: [a-zA-Z_0-9.]+;

// eater
WhitespaceEater: [ \t]+ -> skip ;
NewlineEater: ('\r' '\n'?| '\n') -> skip ;
LineCommentEater: ';' ~[\r\n]* -> skip ;

// string (must after eater)
EndZero: '\\00';
EscapeEnter: '\\n';
EscapeBackslash: '\\\\';
EscapeQuote: '\\"';
StringLiteral: [ -~];

InfoStr: '"' (StringLiteral)*? '"';
