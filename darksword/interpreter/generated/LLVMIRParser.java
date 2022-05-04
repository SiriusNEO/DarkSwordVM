// Generated from ../src/darksword/interpreter/generated/LLVMIR.g4 by ANTLR 4.7.2

    package darksword.interpreter.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLVMIRParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, IntType=52, 
		VoidType=53, LabelType=54, GlobalReg=55, LocalReg=56, NullptrConstant=57, 
		BoolConstant=58, StringConstant=59, LinkageType=60, PreemptionSpecifiers=61, 
		VisibilityStyles=62, GlobalWord=63, UnnamedAddr=64, FuncAttr=65, ParaAttr=66, 
		IntegerLiteral=67, Identifier=68, WhitespaceEater=69, NewlineEater=70, 
		LineCommentEater=71, EndZero=72, EscapeEnter=73, EscapeBackslash=74, EscapeQuote=75, 
		StringLiteral=76, InfoStr=77;
	public static final int
		RULE_rootLLVMIR = 0, RULE_targetInfo = 1, RULE_sourceFn = 2, RULE_dataLayout = 3, 
		RULE_targetTriple = 4, RULE_initExp = 5, RULE_globalDecl = 6, RULE_classDecl = 7, 
		RULE_funcCall = 8, RULE_funcInfo = 9, RULE_funcDecl = 10, RULE_funcDef = 11, 
		RULE_basicBlock = 12, RULE_instDest = 13, RULE_gepOffset = 14, RULE_phiBranch = 15, 
		RULE_cmpOp = 16, RULE_binaryOp = 17, RULE_instruction = 18, RULE_atom = 19, 
		RULE_alignment = 20, RULE_type = 21, RULE_arrayType = 22, RULE_basicType = 23, 
		RULE_integerConstant = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"rootLLVMIR", "targetInfo", "sourceFn", "dataLayout", "targetTriple", 
			"initExp", "globalDecl", "classDecl", "funcCall", "funcInfo", "funcDecl", 
			"funcDef", "basicBlock", "instDest", "gepOffset", "phiBranch", "cmpOp", 
			"binaryOp", "instruction", "atom", "alignment", "type", "arrayType", 
			"basicType", "integerConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'source_filename'", "'='", "'target'", "'datalayout'", "'triple'", 
			"'zeroinitializer'", "'type'", "'{'", "','", "'}'", "'('", "')'", "'declare'", 
			"'define'", "':'", "'['", "']'", "'sgt'", "'sge'", "'slt'", "'sle'", 
			"'eq'", "'ne'", "'add'", "'sub'", "'mul'", "'sdiv'", "'srem'", "'shl'", 
			"'ashr'", "'and'", "'or'", "'xor'", "'alloca'", "'bitcast'", "'to'", 
			"'trunc'", "'zext'", "'br'", "'call'", "'getelementptr'", "'inbounds'", 
			"'icmp'", "'load'", "'store'", "'ret'", "'phi'", "'align'", "'*'", "'x'", 
			"'-'", null, "'void'", "'label'", null, null, "'null'", null, null, null, 
			null, null, null, null, "'nounwind'", "'noalias'", null, null, null, 
			null, null, "'\\00'", "'\\n'", "'\\\\'", "'\\\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "IntType", "VoidType", "LabelType", "GlobalReg", 
			"LocalReg", "NullptrConstant", "BoolConstant", "StringConstant", "LinkageType", 
			"PreemptionSpecifiers", "VisibilityStyles", "GlobalWord", "UnnamedAddr", 
			"FuncAttr", "ParaAttr", "IntegerLiteral", "Identifier", "WhitespaceEater", 
			"NewlineEater", "LineCommentEater", "EndZero", "EscapeEnter", "EscapeBackslash", 
			"EscapeQuote", "StringLiteral", "InfoStr"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LLVMIR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LLVMIRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootLLVMIRContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LLVMIRParser.EOF, 0); }
		public List<TargetInfoContext> targetInfo() {
			return getRuleContexts(TargetInfoContext.class);
		}
		public TargetInfoContext targetInfo(int i) {
			return getRuleContext(TargetInfoContext.class,i);
		}
		public List<FuncDeclContext> funcDecl() {
			return getRuleContexts(FuncDeclContext.class);
		}
		public FuncDeclContext funcDecl(int i) {
			return getRuleContext(FuncDeclContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<GlobalDeclContext> globalDecl() {
			return getRuleContexts(GlobalDeclContext.class);
		}
		public GlobalDeclContext globalDecl(int i) {
			return getRuleContext(GlobalDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public RootLLVMIRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootLLVMIR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterRootLLVMIR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitRootLLVMIR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitRootLLVMIR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootLLVMIRContext rootLLVMIR() throws RecognitionException {
		RootLLVMIRContext _localctx = new RootLLVMIRContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rootLLVMIR);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__12) | (1L << T__13) | (1L << GlobalReg) | (1L << LocalReg))) != 0)) {
				{
				setState(55);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__2:
					{
					setState(50);
					targetInfo();
					}
					break;
				case T__12:
					{
					setState(51);
					funcDecl();
					}
					break;
				case T__13:
					{
					setState(52);
					funcDef();
					}
					break;
				case GlobalReg:
					{
					setState(53);
					globalDecl();
					}
					break;
				case LocalReg:
					{
					setState(54);
					classDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetInfoContext extends ParserRuleContext {
		public SourceFnContext sourceFn() {
			return getRuleContext(SourceFnContext.class,0);
		}
		public DataLayoutContext dataLayout() {
			return getRuleContext(DataLayoutContext.class,0);
		}
		public TargetTripleContext targetTriple() {
			return getRuleContext(TargetTripleContext.class,0);
		}
		public TargetInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterTargetInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitTargetInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitTargetInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetInfoContext targetInfo() throws RecognitionException {
		TargetInfoContext _localctx = new TargetInfoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_targetInfo);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				sourceFn();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				dataLayout();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				targetTriple();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceFnContext extends ParserRuleContext {
		public TerminalNode InfoStr() { return getToken(LLVMIRParser.InfoStr, 0); }
		public SourceFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceFn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterSourceFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitSourceFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitSourceFn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceFnContext sourceFn() throws RecognitionException {
		SourceFnContext _localctx = new SourceFnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sourceFn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__0);
			setState(68);
			match(T__1);
			setState(69);
			match(InfoStr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataLayoutContext extends ParserRuleContext {
		public TerminalNode InfoStr() { return getToken(LLVMIRParser.InfoStr, 0); }
		public DataLayoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataLayout; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterDataLayout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitDataLayout(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitDataLayout(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataLayoutContext dataLayout() throws RecognitionException {
		DataLayoutContext _localctx = new DataLayoutContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dataLayout);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__2);
			setState(72);
			match(T__3);
			setState(73);
			match(T__1);
			setState(74);
			match(InfoStr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetTripleContext extends ParserRuleContext {
		public TerminalNode InfoStr() { return getToken(LLVMIRParser.InfoStr, 0); }
		public TargetTripleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetTriple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterTargetTriple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitTargetTriple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitTargetTriple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetTripleContext targetTriple() throws RecognitionException {
		TargetTripleContext _localctx = new TargetTripleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_targetTriple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__2);
			setState(77);
			match(T__4);
			setState(78);
			match(T__1);
			setState(79);
			match(InfoStr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitExpContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public InitExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterInitExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitInitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitInitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitExpContext initExp() throws RecognitionException {
		InitExpContext _localctx = new InitExpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_initExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__50:
			case GlobalReg:
			case LocalReg:
			case NullptrConstant:
			case BoolConstant:
			case StringConstant:
			case IntegerLiteral:
				{
				setState(81);
				atom();
				}
				break;
			case T__5:
				{
				setState(82);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalDeclContext extends ParserRuleContext {
		public TerminalNode GlobalReg() { return getToken(LLVMIRParser.GlobalReg, 0); }
		public TerminalNode GlobalWord() { return getToken(LLVMIRParser.GlobalWord, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InitExpContext initExp() {
			return getRuleContext(InitExpContext.class,0);
		}
		public TerminalNode LinkageType() { return getToken(LLVMIRParser.LinkageType, 0); }
		public TerminalNode PreemptionSpecifiers() { return getToken(LLVMIRParser.PreemptionSpecifiers, 0); }
		public TerminalNode VisibilityStyles() { return getToken(LLVMIRParser.VisibilityStyles, 0); }
		public TerminalNode UnnamedAddr() { return getToken(LLVMIRParser.UnnamedAddr, 0); }
		public AlignmentContext alignment() {
			return getRuleContext(AlignmentContext.class,0);
		}
		public GlobalDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterGlobalDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitGlobalDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitGlobalDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalDeclContext globalDecl() throws RecognitionException {
		GlobalDeclContext _localctx = new GlobalDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_globalDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(GlobalReg);
			setState(86);
			match(T__1);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LinkageType) {
				{
				setState(87);
				match(LinkageType);
				}
			}

			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PreemptionSpecifiers) {
				{
				setState(90);
				match(PreemptionSpecifiers);
				}
			}

			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VisibilityStyles) {
				{
				setState(93);
				match(VisibilityStyles);
				}
			}

			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UnnamedAddr) {
				{
				setState(96);
				match(UnnamedAddr);
				}
			}

			setState(99);
			match(GlobalWord);
			setState(100);
			type(0);
			setState(101);
			initExp();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(102);
				alignment();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode LocalReg() { return getToken(LLVMIRParser.LocalReg, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(LocalReg);
			setState(106);
			match(T__1);
			setState(107);
			match(T__6);
			setState(108);
			match(T__7);
			setState(109);
			type(0);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(110);
				match(T__8);
				setState(111);
				type(0);
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode GlobalReg() { return getToken(LLVMIRParser.GlobalReg, 0); }
		public TerminalNode ParaAttr() { return getToken(LLVMIRParser.ParaAttr, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ParaAttr) {
				{
				setState(119);
				match(ParaAttr);
				}
			}

			setState(122);
			type(0);
			setState(123);
			match(GlobalReg);
			setState(124);
			match(T__10);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << IntType) | (1L << VoidType) | (1L << LabelType) | (1L << LocalReg))) != 0)) {
				{
				setState(125);
				type(0);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (T__50 - 51)) | (1L << (GlobalReg - 51)) | (1L << (LocalReg - 51)) | (1L << (NullptrConstant - 51)) | (1L << (BoolConstant - 51)) | (1L << (StringConstant - 51)) | (1L << (IntegerLiteral - 51)))) != 0)) {
					{
					setState(126);
					atom();
					}
				}

				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(129);
					match(T__8);
					setState(130);
					type(0);
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & ((1L << (T__50 - 51)) | (1L << (GlobalReg - 51)) | (1L << (LocalReg - 51)) | (1L << (NullptrConstant - 51)) | (1L << (BoolConstant - 51)) | (1L << (StringConstant - 51)) | (1L << (IntegerLiteral - 51)))) != 0)) {
						{
						setState(131);
						atom();
						}
					}

					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(141);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncInfoContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode GlobalReg() { return getToken(LLVMIRParser.GlobalReg, 0); }
		public TerminalNode LinkageType() { return getToken(LLVMIRParser.LinkageType, 0); }
		public TerminalNode PreemptionSpecifiers() { return getToken(LLVMIRParser.PreemptionSpecifiers, 0); }
		public TerminalNode VisibilityStyles() { return getToken(LLVMIRParser.VisibilityStyles, 0); }
		public TerminalNode UnnamedAddr() { return getToken(LLVMIRParser.UnnamedAddr, 0); }
		public TerminalNode FuncAttr() { return getToken(LLVMIRParser.FuncAttr, 0); }
		public List<TerminalNode> LocalReg() { return getTokens(LLVMIRParser.LocalReg); }
		public TerminalNode LocalReg(int i) {
			return getToken(LLVMIRParser.LocalReg, i);
		}
		public FuncInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncInfoContext funcInfo() throws RecognitionException {
		FuncInfoContext _localctx = new FuncInfoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcInfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LinkageType) {
				{
				setState(143);
				match(LinkageType);
				}
			}

			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PreemptionSpecifiers) {
				{
				setState(146);
				match(PreemptionSpecifiers);
				}
			}

			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VisibilityStyles) {
				{
				setState(149);
				match(VisibilityStyles);
				}
			}

			setState(152);
			type(0);
			setState(153);
			match(GlobalReg);
			setState(154);
			match(T__10);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << IntType) | (1L << VoidType) | (1L << LabelType) | (1L << LocalReg))) != 0)) {
				{
				setState(155);
				type(0);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LocalReg) {
					{
					setState(156);
					match(LocalReg);
					}
				}

				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(159);
					match(T__8);
					setState(160);
					type(0);
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LocalReg) {
						{
						setState(161);
						match(LocalReg);
						}
					}

					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(171);
			match(T__11);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UnnamedAddr) {
				{
				setState(172);
				match(UnnamedAddr);
				}
			}

			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FuncAttr) {
				{
				setState(175);
				match(FuncAttr);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDeclContext extends ParserRuleContext {
		public FuncInfoContext funcInfo() {
			return getRuleContext(FuncInfoContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__12);
			setState(179);
			funcInfo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public FuncInfoContext funcInfo() {
			return getRuleContext(FuncInfoContext.class,0);
		}
		public List<BasicBlockContext> basicBlock() {
			return getRuleContexts(BasicBlockContext.class);
		}
		public BasicBlockContext basicBlock(int i) {
			return getRuleContext(BasicBlockContext.class,i);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__13);
			setState(182);
			funcInfo();
			setState(183);
			match(T__7);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(184);
				basicBlock();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicBlockContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LLVMIRParser.Identifier, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BasicBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBasicBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBasicBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBasicBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicBlockContext basicBlock() throws RecognitionException {
		BasicBlockContext _localctx = new BasicBlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_basicBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(Identifier);
			setState(193);
			match(T__14);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__44) | (1L << T__45) | (1L << LocalReg))) != 0)) {
				{
				{
				setState(194);
				instruction();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstDestContext extends ParserRuleContext {
		public TerminalNode LocalReg() { return getToken(LLVMIRParser.LocalReg, 0); }
		public InstDestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instDest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterInstDest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitInstDest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitInstDest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstDestContext instDest() throws RecognitionException {
		InstDestContext _localctx = new InstDestContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_instDest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(LocalReg);
			setState(201);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GepOffsetContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public GepOffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gepOffset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterGepOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitGepOffset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitGepOffset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GepOffsetContext gepOffset() throws RecognitionException {
		GepOffsetContext _localctx = new GepOffsetContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_gepOffset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__8);
			setState(204);
			type(0);
			setState(205);
			atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhiBranchContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public PhiBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phiBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterPhiBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitPhiBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitPhiBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhiBranchContext phiBranch() throws RecognitionException {
		PhiBranchContext _localctx = new PhiBranchContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_phiBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__15);
			setState(208);
			atom();
			setState(209);
			match(T__8);
			setState(210);
			atom();
			setState(211);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmpOpContext extends ParserRuleContext {
		public CmpOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterCmpOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitCmpOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitCmpOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmpOpContext cmpOp() throws RecognitionException {
		CmpOpContext _localctx = new CmpOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cmpOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryOpContext extends ParserRuleContext {
		public BinaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBinaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBinaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBinaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOpContext binaryOp() throws RecognitionException {
		BinaryOpContext _localctx = new BinaryOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_binaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetContext extends InstructionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public RetContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocaContext extends InstructionContext {
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AlignmentContext alignment() {
			return getRuleContext(AlignmentContext.class,0);
		}
		public AllocaContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterAlloca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitAlloca(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitAlloca(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetelementptrContext extends InstructionContext {
		public AtomContext src;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<GepOffsetContext> gepOffset() {
			return getRuleContexts(GepOffsetContext.class);
		}
		public GepOffsetContext gepOffset(int i) {
			return getRuleContext(GepOffsetContext.class,i);
		}
		public GetelementptrContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterGetelementptr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitGetelementptr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitGetelementptr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StoreContext extends InstructionContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public AlignmentContext alignment() {
			return getRuleContext(AlignmentContext.class,0);
		}
		public StoreContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterStore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitStore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitStore(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitcastContext extends InstructionContext {
		public AtomContext src;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public BitcastContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBitcast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBitcast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBitcast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IcmpContext extends InstructionContext {
		public AtomContext lsrc;
		public AtomContext rsrc;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public CmpOpContext cmpOp() {
			return getRuleContext(CmpOpContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public IcmpContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterIcmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitIcmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitIcmp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BrContext extends InstructionContext {
		public AtomContext src;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public BrContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallContext extends InstructionContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public CallContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PhiContext extends InstructionContext {
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<PhiBranchContext> phiBranch() {
			return getRuleContexts(PhiBranchContext.class);
		}
		public PhiBranchContext phiBranch(int i) {
			return getRuleContext(PhiBranchContext.class,i);
		}
		public PhiContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterPhi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitPhi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitPhi(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TruncContext extends InstructionContext {
		public AtomContext src;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TruncContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterTrunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitTrunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitTrunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadContext extends InstructionContext {
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AlignmentContext alignment() {
			return getRuleContext(AlignmentContext.class,0);
		}
		public LoadContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitLoad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitLoad(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryContext extends InstructionContext {
		public AtomContext lsrc;
		public AtomContext rsrc;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public BinaryOpContext binaryOp() {
			return getRuleContext(BinaryOpContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public BinaryContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ZextContext extends InstructionContext {
		public AtomContext src;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ZextContext(InstructionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterZext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitZext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitZext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_instruction);
		int _la;
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new AllocaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				instDest();
				setState(218);
				match(T__33);
				setState(219);
				type(0);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(220);
					alignment();
					}
				}

				}
				break;
			case 2:
				_localctx = new BinaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				instDest();
				setState(224);
				binaryOp();
				setState(225);
				type(0);
				{
				setState(226);
				((BinaryContext)_localctx).lsrc = atom();
				}
				setState(227);
				match(T__8);
				{
				setState(228);
				((BinaryContext)_localctx).rsrc = atom();
				}
				}
				break;
			case 3:
				_localctx = new BitcastContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				instDest();
				setState(231);
				match(T__34);
				setState(232);
				type(0);
				{
				setState(233);
				((BitcastContext)_localctx).src = atom();
				}
				setState(234);
				match(T__35);
				setState(235);
				type(0);
				}
				break;
			case 4:
				_localctx = new TruncContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				instDest();
				setState(238);
				match(T__36);
				setState(239);
				type(0);
				{
				setState(240);
				((TruncContext)_localctx).src = atom();
				}
				setState(241);
				match(T__35);
				setState(242);
				type(0);
				}
				break;
			case 5:
				_localctx = new ZextContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(244);
				instDest();
				setState(245);
				match(T__37);
				setState(246);
				type(0);
				{
				setState(247);
				((ZextContext)_localctx).src = atom();
				}
				setState(248);
				match(T__35);
				setState(249);
				type(0);
				}
				break;
			case 6:
				_localctx = new BrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
				match(T__38);
				setState(252);
				type(0);
				{
				setState(253);
				((BrContext)_localctx).src = atom();
				}
				setState(254);
				match(T__8);
				setState(255);
				type(0);
				setState(256);
				atom();
				setState(257);
				match(T__8);
				setState(258);
				type(0);
				setState(259);
				atom();
				}
				break;
			case 7:
				_localctx = new BrContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(261);
				match(T__38);
				setState(262);
				type(0);
				setState(263);
				atom();
				}
				break;
			case 8:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LocalReg) {
					{
					setState(265);
					instDest();
					}
				}

				setState(268);
				match(T__39);
				setState(269);
				funcCall();
				}
				break;
			case 9:
				_localctx = new GetelementptrContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(270);
				instDest();
				setState(271);
				match(T__40);
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(272);
					match(T__41);
					}
				}

				setState(275);
				type(0);
				setState(276);
				match(T__8);
				setState(277);
				type(0);
				{
				setState(278);
				((GetelementptrContext)_localctx).src = atom();
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(279);
					gepOffset();
					}
					}
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 10:
				_localctx = new IcmpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(285);
				instDest();
				setState(286);
				match(T__42);
				setState(287);
				cmpOp();
				setState(288);
				type(0);
				{
				setState(289);
				((IcmpContext)_localctx).lsrc = atom();
				}
				setState(290);
				match(T__8);
				{
				setState(291);
				((IcmpContext)_localctx).rsrc = atom();
				}
				}
				break;
			case 11:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(293);
				instDest();
				setState(294);
				match(T__43);
				setState(295);
				type(0);
				setState(296);
				match(T__8);
				setState(297);
				type(0);
				setState(298);
				atom();
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(299);
					alignment();
					}
				}

				}
				break;
			case 12:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(302);
				match(T__44);
				setState(303);
				type(0);
				setState(304);
				atom();
				setState(305);
				match(T__8);
				setState(306);
				type(0);
				setState(307);
				atom();
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(308);
					alignment();
					}
				}

				}
				break;
			case 13:
				_localctx = new RetContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(311);
				match(T__45);
				setState(312);
				type(0);
				setState(314);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(313);
					atom();
					}
					break;
				}
				}
				break;
			case 14:
				_localctx = new PhiContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(316);
				instDest();
				setState(317);
				match(T__46);
				setState(318);
				type(0);
				setState(319);
				phiBranch();
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(320);
					match(T__8);
					setState(321);
					phiBranch();
					}
					}
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public IntegerConstantContext integerConstant() {
			return getRuleContext(IntegerConstantContext.class,0);
		}
		public TerminalNode StringConstant() { return getToken(LLVMIRParser.StringConstant, 0); }
		public TerminalNode NullptrConstant() { return getToken(LLVMIRParser.NullptrConstant, 0); }
		public TerminalNode BoolConstant() { return getToken(LLVMIRParser.BoolConstant, 0); }
		public TerminalNode GlobalReg() { return getToken(LLVMIRParser.GlobalReg, 0); }
		public TerminalNode LocalReg() { return getToken(LLVMIRParser.LocalReg, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_atom);
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__50:
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				integerConstant();
				}
				break;
			case StringConstant:
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				match(StringConstant);
				}
				break;
			case NullptrConstant:
				enterOuterAlt(_localctx, 3);
				{
				setState(331);
				match(NullptrConstant);
				}
				break;
			case BoolConstant:
				enterOuterAlt(_localctx, 4);
				{
				setState(332);
				match(BoolConstant);
				}
				break;
			case GlobalReg:
				enterOuterAlt(_localctx, 5);
				{
				setState(333);
				match(GlobalReg);
				}
				break;
			case LocalReg:
				enterOuterAlt(_localctx, 6);
				{
				setState(334);
				match(LocalReg);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlignmentContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(LLVMIRParser.IntegerLiteral, 0); }
		public AlignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterAlignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitAlignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitAlignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlignmentContext alignment() throws RecognitionException {
		AlignmentContext _localctx = new AlignmentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_alignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(T__8);
			setState(338);
			match(T__47);
			setState(339);
			match(IntegerLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Token pointer;
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
			case VoidType:
			case LabelType:
			case LocalReg:
				{
				setState(342);
				basicType();
				}
				break;
			case T__15:
				{
				setState(343);
				arrayType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(346);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					{
					setState(347);
					((TypeContext)_localctx).pointer = match(T__48);
					}
					}
					} 
				}
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public Token arrayLen;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IntegerLiteral() { return getToken(LLVMIRParser.IntegerLiteral, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(T__15);
			{
			setState(354);
			((ArrayTypeContext)_localctx).arrayLen = match(IntegerLiteral);
			}
			setState(355);
			match(T__49);
			setState(356);
			type(0);
			setState(357);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(LLVMIRParser.IntType, 0); }
		public TerminalNode VoidType() { return getToken(LLVMIRParser.VoidType, 0); }
		public TerminalNode LabelType() { return getToken(LLVMIRParser.LabelType, 0); }
		public TerminalNode LocalReg() { return getToken(LLVMIRParser.LocalReg, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << VoidType) | (1L << LabelType) | (1L << LocalReg))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerConstantContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(LLVMIRParser.IntegerLiteral, 0); }
		public IntegerConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterIntegerConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitIntegerConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitIntegerConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerConstantContext integerConstant() throws RecognitionException {
		IntegerConstantContext _localctx = new IntegerConstantContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_integerConstant);
		try {
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(IntegerLiteral);
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(T__50);
				setState(363);
				match(IntegerLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3O\u0171\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3\3\3"+
		"\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\5\7V\n\7\3\b\3\b\3\b\5\b[\n\b\3\b\5\b^\n\b\3\b\5\ba\n\b\3\b\5"+
		"\bd\n\b\3\b\3\b\3\b\3\b\5\bj\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\ts\n\t"+
		"\f\t\16\tv\13\t\3\t\3\t\3\n\5\n{\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0082\n\n"+
		"\3\n\3\n\3\n\5\n\u0087\n\n\7\n\u0089\n\n\f\n\16\n\u008c\13\n\5\n\u008e"+
		"\n\n\3\n\3\n\3\13\5\13\u0093\n\13\3\13\5\13\u0096\n\13\3\13\5\13\u0099"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a0\n\13\3\13\3\13\3\13\5\13\u00a5"+
		"\n\13\7\13\u00a7\n\13\f\13\16\13\u00aa\13\13\5\13\u00ac\n\13\3\13\3\13"+
		"\5\13\u00b0\n\13\3\13\5\13\u00b3\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r"+
		"\u00bc\n\r\f\r\16\r\u00bf\13\r\3\r\3\r\3\16\3\16\3\16\7\16\u00c6\n\16"+
		"\f\16\16\16\u00c9\13\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00e0"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u010d\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u0114\n\24\3"+
		"\24\3\24\3\24\3\24\3\24\7\24\u011b\n\24\f\24\16\24\u011e\13\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5"+
		"\24\u012f\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0138\n\24\3\24"+
		"\3\24\3\24\5\24\u013d\n\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0145\n"+
		"\24\f\24\16\24\u0148\13\24\5\24\u014a\n\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\5\25\u0152\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u015b\n\27"+
		"\3\27\3\27\7\27\u015f\n\27\f\27\16\27\u0162\13\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u016f\n\32\3\32\2\3,\33\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\5\3\2\24\31\3\2\32"+
		"#\4\2\668::\2\u0192\2;\3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\bI\3\2\2\2\nN\3\2"+
		"\2\2\fU\3\2\2\2\16W\3\2\2\2\20k\3\2\2\2\22z\3\2\2\2\24\u0092\3\2\2\2\26"+
		"\u00b4\3\2\2\2\30\u00b7\3\2\2\2\32\u00c2\3\2\2\2\34\u00ca\3\2\2\2\36\u00cd"+
		"\3\2\2\2 \u00d1\3\2\2\2\"\u00d7\3\2\2\2$\u00d9\3\2\2\2&\u0149\3\2\2\2"+
		"(\u0151\3\2\2\2*\u0153\3\2\2\2,\u015a\3\2\2\2.\u0163\3\2\2\2\60\u0169"+
		"\3\2\2\2\62\u016e\3\2\2\2\64:\5\4\3\2\65:\5\26\f\2\66:\5\30\r\2\67:\5"+
		"\16\b\28:\5\20\t\29\64\3\2\2\29\65\3\2\2\29\66\3\2\2\29\67\3\2\2\298\3"+
		"\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\2\2\3?\3"+
		"\3\2\2\2@D\5\6\4\2AD\5\b\5\2BD\5\n\6\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D"+
		"\5\3\2\2\2EF\7\3\2\2FG\7\4\2\2GH\7O\2\2H\7\3\2\2\2IJ\7\5\2\2JK\7\6\2\2"+
		"KL\7\4\2\2LM\7O\2\2M\t\3\2\2\2NO\7\5\2\2OP\7\7\2\2PQ\7\4\2\2QR\7O\2\2"+
		"R\13\3\2\2\2SV\5(\25\2TV\7\b\2\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\79\2"+
		"\2XZ\7\4\2\2Y[\7>\2\2ZY\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\^\7?\2\2]\\\3\2\2"+
		"\2]^\3\2\2\2^`\3\2\2\2_a\7@\2\2`_\3\2\2\2`a\3\2\2\2ac\3\2\2\2bd\7B\2\2"+
		"cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7A\2\2fg\5,\27\2gi\5\f\7\2hj\5*\26\2"+
		"ih\3\2\2\2ij\3\2\2\2j\17\3\2\2\2kl\7:\2\2lm\7\4\2\2mn\7\t\2\2no\7\n\2"+
		"\2ot\5,\27\2pq\7\13\2\2qs\5,\27\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2"+
		"\2\2uw\3\2\2\2vt\3\2\2\2wx\7\f\2\2x\21\3\2\2\2y{\7D\2\2zy\3\2\2\2z{\3"+
		"\2\2\2{|\3\2\2\2|}\5,\27\2}~\79\2\2~\u008d\7\r\2\2\177\u0081\5,\27\2\u0080"+
		"\u0082\5(\25\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u008a\3\2"+
		"\2\2\u0083\u0084\7\13\2\2\u0084\u0086\5,\27\2\u0085\u0087\5(\25\2\u0086"+
		"\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0083\3\2"+
		"\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008d\177\3\2\2\2\u008d\u008e\3\2\2"+
		"\2\u008e\u008f\3\2\2\2\u008f\u0090\7\16\2\2\u0090\23\3\2\2\2\u0091\u0093"+
		"\7>\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0096\7?\2\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2"+
		"\2\2\u0097\u0099\7@\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009b\5,\27\2\u009b\u009c\79\2\2\u009c\u00ab\7\r"+
		"\2\2\u009d\u009f\5,\27\2\u009e\u00a0\7:\2\2\u009f\u009e\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a8\3\2\2\2\u00a1\u00a2\7\13\2\2\u00a2\u00a4\5"+
		",\27\2\u00a3\u00a5\7:\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u009d\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\7\16"+
		"\2\2\u00ae\u00b0\7B\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u00b3\7C\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\25\3\2\2\2\u00b4\u00b5\7\17\2\2\u00b5\u00b6\5\24\13\2\u00b6"+
		"\27\3\2\2\2\u00b7\u00b8\7\20\2\2\u00b8\u00b9\5\24\13\2\u00b9\u00bd\7\n"+
		"\2\2\u00ba\u00bc\5\32\16\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c1\7\f\2\2\u00c1\31\3\2\2\2\u00c2\u00c3\7F\2\2\u00c3\u00c7"+
		"\7\21\2\2\u00c4\u00c6\5&\24\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2"+
		"\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00ca\u00cb\7:\2\2\u00cb\u00cc\7\4\2\2\u00cc\35\3\2\2\2\u00cd"+
		"\u00ce\7\13\2\2\u00ce\u00cf\5,\27\2\u00cf\u00d0\5(\25\2\u00d0\37\3\2\2"+
		"\2\u00d1\u00d2\7\22\2\2\u00d2\u00d3\5(\25\2\u00d3\u00d4\7\13\2\2\u00d4"+
		"\u00d5\5(\25\2\u00d5\u00d6\7\23\2\2\u00d6!\3\2\2\2\u00d7\u00d8\t\2\2\2"+
		"\u00d8#\3\2\2\2\u00d9\u00da\t\3\2\2\u00da%\3\2\2\2\u00db\u00dc\5\34\17"+
		"\2\u00dc\u00dd\7$\2\2\u00dd\u00df\5,\27\2\u00de\u00e0\5*\26\2\u00df\u00de"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u014a\3\2\2\2\u00e1\u00e2\5\34\17\2"+
		"\u00e2\u00e3\5$\23\2\u00e3\u00e4\5,\27\2\u00e4\u00e5\5(\25\2\u00e5\u00e6"+
		"\7\13\2\2\u00e6\u00e7\5(\25\2\u00e7\u014a\3\2\2\2\u00e8\u00e9\5\34\17"+
		"\2\u00e9\u00ea\7%\2\2\u00ea\u00eb\5,\27\2\u00eb\u00ec\5(\25\2\u00ec\u00ed"+
		"\7&\2\2\u00ed\u00ee\5,\27\2\u00ee\u014a\3\2\2\2\u00ef\u00f0\5\34\17\2"+
		"\u00f0\u00f1\7\'\2\2\u00f1\u00f2\5,\27\2\u00f2\u00f3\5(\25\2\u00f3\u00f4"+
		"\7&\2\2\u00f4\u00f5\5,\27\2\u00f5\u014a\3\2\2\2\u00f6\u00f7\5\34\17\2"+
		"\u00f7\u00f8\7(\2\2\u00f8\u00f9\5,\27\2\u00f9\u00fa\5(\25\2\u00fa\u00fb"+
		"\7&\2\2\u00fb\u00fc\5,\27\2\u00fc\u014a\3\2\2\2\u00fd\u00fe\7)\2\2\u00fe"+
		"\u00ff\5,\27\2\u00ff\u0100\5(\25\2\u0100\u0101\7\13\2\2\u0101\u0102\5"+
		",\27\2\u0102\u0103\5(\25\2\u0103\u0104\7\13\2\2\u0104\u0105\5,\27\2\u0105"+
		"\u0106\5(\25\2\u0106\u014a\3\2\2\2\u0107\u0108\7)\2\2\u0108\u0109\5,\27"+
		"\2\u0109\u010a\5(\25\2\u010a\u014a\3\2\2\2\u010b\u010d\5\34\17\2\u010c"+
		"\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\7*"+
		"\2\2\u010f\u014a\5\22\n\2\u0110\u0111\5\34\17\2\u0111\u0113\7+\2\2\u0112"+
		"\u0114\7,\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0116\5,\27\2\u0116\u0117\7\13\2\2\u0117\u0118\5,\27\2\u0118"+
		"\u011c\5(\25\2\u0119\u011b\5\36\20\2\u011a\u0119\3\2\2\2\u011b\u011e\3"+
		"\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u014a\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0120\5\34\17\2\u0120\u0121\7-\2\2\u0121\u0122\5"+
		"\"\22\2\u0122\u0123\5,\27\2\u0123\u0124\5(\25\2\u0124\u0125\7\13\2\2\u0125"+
		"\u0126\5(\25\2\u0126\u014a\3\2\2\2\u0127\u0128\5\34\17\2\u0128\u0129\7"+
		".\2\2\u0129\u012a\5,\27\2\u012a\u012b\7\13\2\2\u012b\u012c\5,\27\2\u012c"+
		"\u012e\5(\25\2\u012d\u012f\5*\26\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012f\u014a\3\2\2\2\u0130\u0131\7/\2\2\u0131\u0132\5,\27\2\u0132"+
		"\u0133\5(\25\2\u0133\u0134\7\13\2\2\u0134\u0135\5,\27\2\u0135\u0137\5"+
		"(\25\2\u0136\u0138\5*\26\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u014a\3\2\2\2\u0139\u013a\7\60\2\2\u013a\u013c\5,\27\2\u013b\u013d\5"+
		"(\25\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u014a\3\2\2\2\u013e"+
		"\u013f\5\34\17\2\u013f\u0140\7\61\2\2\u0140\u0141\5,\27\2\u0141\u0146"+
		"\5 \21\2\u0142\u0143\7\13\2\2\u0143\u0145\5 \21\2\u0144\u0142\3\2\2\2"+
		"\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u014a"+
		"\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u00db\3\2\2\2\u0149\u00e1\3\2\2\2\u0149"+
		"\u00e8\3\2\2\2\u0149\u00ef\3\2\2\2\u0149\u00f6\3\2\2\2\u0149\u00fd\3\2"+
		"\2\2\u0149\u0107\3\2\2\2\u0149\u010c\3\2\2\2\u0149\u0110\3\2\2\2\u0149"+
		"\u011f\3\2\2\2\u0149\u0127\3\2\2\2\u0149\u0130\3\2\2\2\u0149\u0139\3\2"+
		"\2\2\u0149\u013e\3\2\2\2\u014a\'\3\2\2\2\u014b\u0152\5\62\32\2\u014c\u0152"+
		"\7=\2\2\u014d\u0152\7;\2\2\u014e\u0152\7<\2\2\u014f\u0152\79\2\2\u0150"+
		"\u0152\7:\2\2\u0151\u014b\3\2\2\2\u0151\u014c\3\2\2\2\u0151\u014d\3\2"+
		"\2\2\u0151\u014e\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152"+
		")\3\2\2\2\u0153\u0154\7\13\2\2\u0154\u0155\7\62\2\2\u0155\u0156\7E\2\2"+
		"\u0156+\3\2\2\2\u0157\u0158\b\27\1\2\u0158\u015b\5\60\31\2\u0159\u015b"+
		"\5.\30\2\u015a\u0157\3\2\2\2\u015a\u0159\3\2\2\2\u015b\u0160\3\2\2\2\u015c"+
		"\u015d\f\5\2\2\u015d\u015f\7\63\2\2\u015e\u015c\3\2\2\2\u015f\u0162\3"+
		"\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161-\3\2\2\2\u0162\u0160"+
		"\3\2\2\2\u0163\u0164\7\22\2\2\u0164\u0165\7E\2\2\u0165\u0166\7\64\2\2"+
		"\u0166\u0167\5,\27\2\u0167\u0168\7\23\2\2\u0168/\3\2\2\2\u0169\u016a\t"+
		"\4\2\2\u016a\61\3\2\2\2\u016b\u016f\7E\2\2\u016c\u016d\7\65\2\2\u016d"+
		"\u016f\7E\2\2\u016e\u016b\3\2\2\2\u016e\u016c\3\2\2\2\u016f\63\3\2\2\2"+
		")9;CUZ]`citz\u0081\u0086\u008a\u008d\u0092\u0095\u0098\u009f\u00a4\u00a8"+
		"\u00ab\u00af\u00b2\u00bd\u00c7\u00df\u010c\u0113\u011c\u012e\u0137\u013c"+
		"\u0146\u0149\u0151\u015a\u0160\u016e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}