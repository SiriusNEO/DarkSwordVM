grammar LLVMIR;

// Add Package Automatically
@header {
    package darksword.interpreter.generated;
}

rootLLVMIR: (targetInfo | funcDecl | funcDef | globalDecl)* EOF;

// target info
targetInfo: sourceFn | dataLayout | targetTriple;
sourceFn: 'source_filename' '=' InfoStr;
dataLayout: 'target' 'datalayout' '=' InfoStr;
targetTriple: 'target' 'triple' '=' InfoStr;

// globalDecl
initExp: (atom | 'zeroinitializer');
globalDecl: GlobalReg '=' 'global' type initExp align?;

// function
funcHeader: GlobalReg '(' (type LocalReg? (',' type LocalReg?)*)? ')';
funcDecl: 'declare' type funcHeader;
funcDef: 'define' type funcHeader '{' (basicBlock)* '}';

// block
basicBlock: Identifier ':' (instruction)*;

// inst
instDest: LocalReg '=';

gepOffset: ',' type atom;
phiBranch: '[' atom ',' atom ']';

instruction
    :   instDest 'alloca' type align?                                #alloca
    |   instDest (binaryOp = 'add' | 'sub' | 'mul' | 'sdiv' | 'srem' | 'shl' | 'ashr' | 'and' | 'or' | 'xor')
        type (lsrc = atom) ',' (rsrc = atom)                         #binary
    |   instDest '=' 'bitcast' type (src = atom) 'to' type           #bitcast
    |   instDest 'trunc'   type (src = atom) 'to' type               #trunc
    |   instDest 'zext'    type (src = atom) 'to' type               #zext
    |   'br' type (src = atom) ',' type atom ',' type atom           #br
    |   'br' type atom                                               #br
    |   instDest? 'call' type funcHeader                             #call
    |   instDest 'getelementptr'
        type ',' type (src = atom) (gepOffset)*                      #getelementptr
    |   instDest 'icmp'
        (cmpOp = 'sgt' | 'sge' | 'slt' | 'sle' | 'eq' | 'ne')
        type (lsrc = atom) (rsrc = atom)                             #icmp
    |   instDest 'load'  type ',' type atom align?                   #load
    |   'store' type atom ',' type atom align?                       #store
    |   'ret' type (atom)?                                           #ret
    |   instDest 'phi' type phiBranch (',' phiBranch)*               #phi
    ;

// atom
atom:  integerConstant | stringConstant | NullptrConstant | BoolConstant | GlobalReg | LocalReg;

// align
align: ',' 'align' IntegerLiteral;

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
stringConstant
    :   'c"' (EscapeEnter | EscapeBackslash | EscapeQuote | StringLiteral)*? '\\00"'
    ;

// basic
IntegerLiteral: '0' | [1-9][0-9]*;
Identifier: [a-zA-Z_0-9.]+;

// eater
WhitespaceEater: [ \t]+ -> skip ;
NewlineEater: ('\r' '\n'?| '\n') -> skip ;
LineCommentEater: ';' ~[\r\n]* -> skip ;

// string (must after eater)
EscapeEnter: '\\n';
EscapeBackslash: '\\\\';
EscapeQuote: '\\"';
StringLiteral: [ -~];

InfoStr: '"' (StringLiteral)*? '"';
