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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		IntType=53, VoidType=54, LabelType=55, GlobalReg=56, LocalReg=57, NullptrConstant=58, 
		BoolConstant=59, IntegerLiteral=60, Identifier=61, WhitespaceEater=62, 
		NewlineEater=63, LineCommentEater=64, EscapeEnter=65, EscapeBackslash=66, 
		EscapeQuote=67, StringLiteral=68, InfoStr=69;
	public static final int
		RULE_rootLLVMIR = 0, RULE_targetInfo = 1, RULE_sourceFn = 2, RULE_dataLayout = 3, 
		RULE_targetTriple = 4, RULE_initExp = 5, RULE_globalDecl = 6, RULE_funcHeader = 7, 
		RULE_funcDecl = 8, RULE_funcDef = 9, RULE_basicBlock = 10, RULE_instDest = 11, 
		RULE_gepOffset = 12, RULE_phiBranch = 13, RULE_instruction = 14, RULE_atom = 15, 
		RULE_align = 16, RULE_type = 17, RULE_arrayType = 18, RULE_basicType = 19, 
		RULE_integerConstant = 20, RULE_stringConstant = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"rootLLVMIR", "targetInfo", "sourceFn", "dataLayout", "targetTriple", 
			"initExp", "globalDecl", "funcHeader", "funcDecl", "funcDef", "basicBlock", 
			"instDest", "gepOffset", "phiBranch", "instruction", "atom", "align", 
			"type", "arrayType", "basicType", "integerConstant", "stringConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'source_filename'", "'='", "'target'", "'datalayout'", "'triple'", 
			"'zeroinitializer'", "'global'", "'('", "','", "')'", "'declare'", "'define'", 
			"'{'", "'}'", "':'", "'['", "']'", "'alloca'", "'add'", "'sub'", "'mul'", 
			"'sdiv'", "'srem'", "'shl'", "'ashr'", "'and'", "'or'", "'xor'", "'bitcast'", 
			"'to'", "'trunc'", "'zext'", "'br'", "'call'", "'getelementptr'", "'icmp'", 
			"'sgt'", "'sge'", "'slt'", "'sle'", "'eq'", "'ne'", "'load'", "'store'", 
			"'ret'", "'phi'", "'align'", "'*'", "'x'", "'-'", "'c\"'", "'\\00\"'", 
			null, "'void'", "'label'", null, null, "'null'", null, null, null, null, 
			null, null, "'\\n'", "'\\\\'", "'\\\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "IntType", "VoidType", "LabelType", "GlobalReg", 
			"LocalReg", "NullptrConstant", "BoolConstant", "IntegerLiteral", "Identifier", 
			"WhitespaceEater", "NewlineEater", "LineCommentEater", "EscapeEnter", 
			"EscapeBackslash", "EscapeQuote", "StringLiteral", "InfoStr"
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
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << GlobalReg))) != 0)) {
				{
				setState(48);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__2:
					{
					setState(44);
					targetInfo();
					}
					break;
				case T__10:
					{
					setState(45);
					funcDecl();
					}
					break;
				case T__11:
					{
					setState(46);
					funcDef();
					}
					break;
				case GlobalReg:
					{
					setState(47);
					globalDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				sourceFn();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				dataLayout();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
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
			setState(60);
			match(T__0);
			setState(61);
			match(T__1);
			setState(62);
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
			setState(64);
			match(T__2);
			setState(65);
			match(T__3);
			setState(66);
			match(T__1);
			setState(67);
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
			setState(69);
			match(T__2);
			setState(70);
			match(T__4);
			setState(71);
			match(T__1);
			setState(72);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__49:
			case T__50:
			case GlobalReg:
			case LocalReg:
			case NullptrConstant:
			case BoolConstant:
			case IntegerLiteral:
				{
				setState(74);
				atom();
				}
				break;
			case T__5:
				{
				setState(75);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InitExpContext initExp() {
			return getRuleContext(InitExpContext.class,0);
		}
		public AlignContext align() {
			return getRuleContext(AlignContext.class,0);
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
			setState(78);
			match(GlobalReg);
			setState(79);
			match(T__1);
			setState(80);
			match(T__6);
			setState(81);
			type(0);
			setState(82);
			initExp();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(83);
				align();
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

	public static class FuncHeaderContext extends ParserRuleContext {
		public TerminalNode GlobalReg() { return getToken(LLVMIRParser.GlobalReg, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> LocalReg() { return getTokens(LLVMIRParser.LocalReg); }
		public TerminalNode LocalReg(int i) {
			return getToken(LLVMIRParser.LocalReg, i);
		}
		public FuncHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterFuncHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitFuncHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitFuncHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncHeaderContext funcHeader() throws RecognitionException {
		FuncHeaderContext _localctx = new FuncHeaderContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(GlobalReg);
			setState(87);
			match(T__7);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << IntType) | (1L << VoidType) | (1L << LabelType) | (1L << LocalReg))) != 0)) {
				{
				setState(88);
				type(0);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LocalReg) {
					{
					setState(89);
					match(LocalReg);
					}
				}

				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(92);
					match(T__8);
					setState(93);
					type(0);
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LocalReg) {
						{
						setState(94);
						match(LocalReg);
						}
					}

					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(104);
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

	public static class FuncDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncHeaderContext funcHeader() {
			return getRuleContext(FuncHeaderContext.class,0);
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
		enterRule(_localctx, 16, RULE_funcDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__10);
			setState(107);
			type(0);
			setState(108);
			funcHeader();
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncHeaderContext funcHeader() {
			return getRuleContext(FuncHeaderContext.class,0);
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
		enterRule(_localctx, 18, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__11);
			setState(111);
			type(0);
			setState(112);
			funcHeader();
			setState(113);
			match(T__12);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(114);
				basicBlock();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(T__13);
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
		enterRule(_localctx, 20, RULE_basicBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(Identifier);
			setState(123);
			match(T__14);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__43) | (1L << T__44) | (1L << LocalReg))) != 0)) {
				{
				{
				setState(124);
				instruction();
				}
				}
				setState(129);
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
		enterRule(_localctx, 22, RULE_instDest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(LocalReg);
			setState(131);
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
		enterRule(_localctx, 24, RULE_gepOffset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__8);
			setState(134);
			type(0);
			setState(135);
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
		enterRule(_localctx, 26, RULE_phiBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__15);
			setState(138);
			atom();
			setState(139);
			match(T__8);
			setState(140);
			atom();
			setState(141);
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
		public AlignContext align() {
			return getRuleContext(AlignContext.class,0);
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
		public AlignContext align() {
			return getRuleContext(AlignContext.class,0);
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
		public Token cmpOp;
		public AtomContext lsrc;
		public AtomContext rsrc;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncHeaderContext funcHeader() {
			return getRuleContext(FuncHeaderContext.class,0);
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
		public AlignContext align() {
			return getRuleContext(AlignContext.class,0);
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
		public Token binaryOp;
		public AtomContext lsrc;
		public AtomContext rsrc;
		public InstDestContext instDest() {
			return getRuleContext(InstDestContext.class,0);
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
		enterRule(_localctx, 28, RULE_instruction);
		int _la;
		try {
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new AllocaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				instDest();
				setState(144);
				match(T__17);
				setState(145);
				type(0);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(146);
					align();
					}
				}

				}
				break;
			case 2:
				_localctx = new BinaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				instDest();
				setState(160);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__18:
					{
					setState(150);
					((BinaryContext)_localctx).binaryOp = match(T__18);
					}
					break;
				case T__19:
					{
					setState(151);
					match(T__19);
					}
					break;
				case T__20:
					{
					setState(152);
					match(T__20);
					}
					break;
				case T__21:
					{
					setState(153);
					match(T__21);
					}
					break;
				case T__22:
					{
					setState(154);
					match(T__22);
					}
					break;
				case T__23:
					{
					setState(155);
					match(T__23);
					}
					break;
				case T__24:
					{
					setState(156);
					match(T__24);
					}
					break;
				case T__25:
					{
					setState(157);
					match(T__25);
					}
					break;
				case T__26:
					{
					setState(158);
					match(T__26);
					}
					break;
				case T__27:
					{
					setState(159);
					match(T__27);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(162);
				type(0);
				{
				setState(163);
				((BinaryContext)_localctx).lsrc = atom();
				}
				setState(164);
				match(T__8);
				{
				setState(165);
				((BinaryContext)_localctx).rsrc = atom();
				}
				}
				break;
			case 3:
				_localctx = new BitcastContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				instDest();
				setState(168);
				match(T__1);
				setState(169);
				match(T__28);
				setState(170);
				type(0);
				{
				setState(171);
				((BitcastContext)_localctx).src = atom();
				}
				setState(172);
				match(T__29);
				setState(173);
				type(0);
				}
				break;
			case 4:
				_localctx = new TruncContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				instDest();
				setState(176);
				match(T__30);
				setState(177);
				type(0);
				{
				setState(178);
				((TruncContext)_localctx).src = atom();
				}
				setState(179);
				match(T__29);
				setState(180);
				type(0);
				}
				break;
			case 5:
				_localctx = new ZextContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				instDest();
				setState(183);
				match(T__31);
				setState(184);
				type(0);
				{
				setState(185);
				((ZextContext)_localctx).src = atom();
				}
				setState(186);
				match(T__29);
				setState(187);
				type(0);
				}
				break;
			case 6:
				_localctx = new BrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(189);
				match(T__32);
				setState(190);
				type(0);
				{
				setState(191);
				((BrContext)_localctx).src = atom();
				}
				setState(192);
				match(T__8);
				setState(193);
				type(0);
				setState(194);
				atom();
				setState(195);
				match(T__8);
				setState(196);
				type(0);
				setState(197);
				atom();
				}
				break;
			case 7:
				_localctx = new BrContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(199);
				match(T__32);
				setState(200);
				type(0);
				setState(201);
				atom();
				}
				break;
			case 8:
				_localctx = new CallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LocalReg) {
					{
					setState(203);
					instDest();
					}
				}

				setState(206);
				match(T__33);
				setState(207);
				type(0);
				setState(208);
				funcHeader();
				}
				break;
			case 9:
				_localctx = new GetelementptrContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(210);
				instDest();
				setState(211);
				match(T__34);
				setState(212);
				type(0);
				setState(213);
				match(T__8);
				setState(214);
				type(0);
				{
				setState(215);
				((GetelementptrContext)_localctx).src = atom();
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(216);
					gepOffset();
					}
					}
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 10:
				_localctx = new IcmpContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(222);
				instDest();
				setState(223);
				match(T__35);
				setState(230);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__36:
					{
					setState(224);
					((IcmpContext)_localctx).cmpOp = match(T__36);
					}
					break;
				case T__37:
					{
					setState(225);
					match(T__37);
					}
					break;
				case T__38:
					{
					setState(226);
					match(T__38);
					}
					break;
				case T__39:
					{
					setState(227);
					match(T__39);
					}
					break;
				case T__40:
					{
					setState(228);
					match(T__40);
					}
					break;
				case T__41:
					{
					setState(229);
					match(T__41);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(232);
				type(0);
				{
				setState(233);
				((IcmpContext)_localctx).lsrc = atom();
				}
				{
				setState(234);
				((IcmpContext)_localctx).rsrc = atom();
				}
				}
				break;
			case 11:
				_localctx = new LoadContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(236);
				instDest();
				setState(237);
				match(T__42);
				setState(238);
				type(0);
				setState(239);
				match(T__8);
				setState(240);
				type(0);
				setState(241);
				atom();
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(242);
					align();
					}
				}

				}
				break;
			case 12:
				_localctx = new StoreContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(245);
				match(T__43);
				setState(246);
				type(0);
				setState(247);
				atom();
				setState(248);
				match(T__8);
				setState(249);
				type(0);
				setState(250);
				atom();
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(251);
					align();
					}
				}

				}
				break;
			case 13:
				_localctx = new RetContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(254);
				match(T__44);
				setState(255);
				type(0);
				setState(257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(256);
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
				setState(259);
				instDest();
				setState(260);
				match(T__45);
				setState(261);
				type(0);
				setState(262);
				phiBranch();
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(263);
					match(T__8);
					setState(264);
					phiBranch();
					}
					}
					setState(269);
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
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_atom);
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__49:
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				integerConstant();
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				stringConstant();
				}
				break;
			case NullptrConstant:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				match(NullptrConstant);
				}
				break;
			case BoolConstant:
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				match(BoolConstant);
				}
				break;
			case GlobalReg:
				enterOuterAlt(_localctx, 5);
				{
				setState(276);
				match(GlobalReg);
				}
				break;
			case LocalReg:
				enterOuterAlt(_localctx, 6);
				{
				setState(277);
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

	public static class AlignContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(LLVMIRParser.IntegerLiteral, 0); }
		public AlignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_align; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterAlign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitAlign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitAlign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlignContext align() throws RecognitionException {
		AlignContext _localctx = new AlignContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_align);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__8);
			setState(281);
			match(T__46);
			setState(282);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
			case VoidType:
			case LabelType:
			case LocalReg:
				{
				setState(285);
				basicType();
				}
				break;
			case T__15:
				{
				setState(286);
				arrayType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(289);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					{
					setState(290);
					((TypeContext)_localctx).pointer = match(T__47);
					}
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 36, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(T__15);
			{
			setState(297);
			((ArrayTypeContext)_localctx).arrayLen = match(IntegerLiteral);
			}
			setState(298);
			match(T__48);
			setState(299);
			type(0);
			setState(300);
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
		enterRule(_localctx, 38, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
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
		enterRule(_localctx, 40, RULE_integerConstant);
		try {
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				match(IntegerLiteral);
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(T__49);
				setState(306);
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

	public static class StringConstantContext extends ParserRuleContext {
		public List<TerminalNode> EscapeEnter() { return getTokens(LLVMIRParser.EscapeEnter); }
		public TerminalNode EscapeEnter(int i) {
			return getToken(LLVMIRParser.EscapeEnter, i);
		}
		public List<TerminalNode> EscapeBackslash() { return getTokens(LLVMIRParser.EscapeBackslash); }
		public TerminalNode EscapeBackslash(int i) {
			return getToken(LLVMIRParser.EscapeBackslash, i);
		}
		public List<TerminalNode> EscapeQuote() { return getTokens(LLVMIRParser.EscapeQuote); }
		public TerminalNode EscapeQuote(int i) {
			return getToken(LLVMIRParser.EscapeQuote, i);
		}
		public List<TerminalNode> StringLiteral() { return getTokens(LLVMIRParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(LLVMIRParser.StringLiteral, i);
		}
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMIRListener ) ((LLVMIRListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLVMIRVisitor ) return ((LLVMIRVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_stringConstant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(T__50);
			setState(313);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(310);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (EscapeEnter - 65)) | (1L << (EscapeBackslash - 65)) | (1L << (EscapeQuote - 65)) | (1L << (StringLiteral - 65)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(316);
			match(T__51);
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
		case 17:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u0141\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\7\2"+
		"\63\n\2\f\2\16\2\66\13\2\3\2\3\2\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7O\n\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\bW\n\b\3\t\3\t\3\t\3\t\5\t]\n\t\3\t\3\t\3\t\5\tb\n\t\7"+
		"\td\n\t\f\t\16\tg\13\t\5\ti\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\7\13v\n\13\f\13\16\13y\13\13\3\13\3\13\3\f\3\f\3\f\7\f\u0080"+
		"\n\f\f\f\16\f\u0083\13\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u0096\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a3\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00cf\n\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00dc\n\20\f\20"+
		"\16\20\u00df\13\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e9"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f6"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ff\n\20\3\20\3\20\3\20"+
		"\5\20\u0104\n\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u010c\n\20\f\20\16"+
		"\20\u010f\13\20\5\20\u0111\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0119"+
		"\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u0122\n\23\3\23\3\23\7\23"+
		"\u0126\n\23\f\23\16\23\u0129\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\5\26\u0136\n\26\3\27\3\27\7\27\u013a\n\27\f\27\16"+
		"\27\u013d\13\27\3\27\3\27\3\27\3\u013b\3$\30\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,\2\4\4\2\679;;\3\2CF\2\u0163\2\64\3\2\2\2\4<\3\2\2"+
		"\2\6>\3\2\2\2\bB\3\2\2\2\nG\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2"+
		"\22l\3\2\2\2\24p\3\2\2\2\26|\3\2\2\2\30\u0084\3\2\2\2\32\u0087\3\2\2\2"+
		"\34\u008b\3\2\2\2\36\u0110\3\2\2\2 \u0118\3\2\2\2\"\u011a\3\2\2\2$\u0121"+
		"\3\2\2\2&\u012a\3\2\2\2(\u0130\3\2\2\2*\u0135\3\2\2\2,\u0137\3\2\2\2."+
		"\63\5\4\3\2/\63\5\22\n\2\60\63\5\24\13\2\61\63\5\16\b\2\62.\3\2\2\2\62"+
		"/\3\2\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65"+
		"\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\678\7\2\2\38\3\3\2\2\29=\5\6\4\2"+
		":=\5\b\5\2;=\5\n\6\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=\5\3\2\2\2>?\7\3\2"+
		"\2?@\7\4\2\2@A\7G\2\2A\7\3\2\2\2BC\7\5\2\2CD\7\6\2\2DE\7\4\2\2EF\7G\2"+
		"\2F\t\3\2\2\2GH\7\5\2\2HI\7\7\2\2IJ\7\4\2\2JK\7G\2\2K\13\3\2\2\2LO\5 "+
		"\21\2MO\7\b\2\2NL\3\2\2\2NM\3\2\2\2O\r\3\2\2\2PQ\7:\2\2QR\7\4\2\2RS\7"+
		"\t\2\2ST\5$\23\2TV\5\f\7\2UW\5\"\22\2VU\3\2\2\2VW\3\2\2\2W\17\3\2\2\2"+
		"XY\7:\2\2Yh\7\n\2\2Z\\\5$\23\2[]\7;\2\2\\[\3\2\2\2\\]\3\2\2\2]e\3\2\2"+
		"\2^_\7\13\2\2_a\5$\23\2`b\7;\2\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2c^\3\2\2"+
		"\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2hZ\3\2\2\2hi\3\2\2"+
		"\2ij\3\2\2\2jk\7\f\2\2k\21\3\2\2\2lm\7\r\2\2mn\5$\23\2no\5\20\t\2o\23"+
		"\3\2\2\2pq\7\16\2\2qr\5$\23\2rs\5\20\t\2sw\7\17\2\2tv\5\26\f\2ut\3\2\2"+
		"\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\20\2\2{\25\3"+
		"\2\2\2|}\7?\2\2}\u0081\7\21\2\2~\u0080\5\36\20\2\177~\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\27\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0085\7;\2\2\u0085\u0086\7\4\2\2\u0086\31\3\2\2\2"+
		"\u0087\u0088\7\13\2\2\u0088\u0089\5$\23\2\u0089\u008a\5 \21\2\u008a\33"+
		"\3\2\2\2\u008b\u008c\7\22\2\2\u008c\u008d\5 \21\2\u008d\u008e\7\13\2\2"+
		"\u008e\u008f\5 \21\2\u008f\u0090\7\23\2\2\u0090\35\3\2\2\2\u0091\u0092"+
		"\5\30\r\2\u0092\u0093\7\24\2\2\u0093\u0095\5$\23\2\u0094\u0096\5\"\22"+
		"\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0111\3\2\2\2\u0097\u00a2"+
		"\5\30\r\2\u0098\u00a3\7\25\2\2\u0099\u00a3\7\26\2\2\u009a\u00a3\7\27\2"+
		"\2\u009b\u00a3\7\30\2\2\u009c\u00a3\7\31\2\2\u009d\u00a3\7\32\2\2\u009e"+
		"\u00a3\7\33\2\2\u009f\u00a3\7\34\2\2\u00a0\u00a3\7\35\2\2\u00a1\u00a3"+
		"\7\36\2\2\u00a2\u0098\3\2\2\2\u00a2\u0099\3\2\2\2\u00a2\u009a\3\2\2\2"+
		"\u00a2\u009b\3\2\2\2\u00a2\u009c\3\2\2\2\u00a2\u009d\3\2\2\2\u00a2\u009e"+
		"\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\5$\23\2\u00a5\u00a6\5 \21\2\u00a6\u00a7\7\13"+
		"\2\2\u00a7\u00a8\5 \21\2\u00a8\u0111\3\2\2\2\u00a9\u00aa\5\30\r\2\u00aa"+
		"\u00ab\7\4\2\2\u00ab\u00ac\7\37\2\2\u00ac\u00ad\5$\23\2\u00ad\u00ae\5"+
		" \21\2\u00ae\u00af\7 \2\2\u00af\u00b0\5$\23\2\u00b0\u0111\3\2\2\2\u00b1"+
		"\u00b2\5\30\r\2\u00b2\u00b3\7!\2\2\u00b3\u00b4\5$\23\2\u00b4\u00b5\5 "+
		"\21\2\u00b5\u00b6\7 \2\2\u00b6\u00b7\5$\23\2\u00b7\u0111\3\2\2\2\u00b8"+
		"\u00b9\5\30\r\2\u00b9\u00ba\7\"\2\2\u00ba\u00bb\5$\23\2\u00bb\u00bc\5"+
		" \21\2\u00bc\u00bd\7 \2\2\u00bd\u00be\5$\23\2\u00be\u0111\3\2\2\2\u00bf"+
		"\u00c0\7#\2\2\u00c0\u00c1\5$\23\2\u00c1\u00c2\5 \21\2\u00c2\u00c3\7\13"+
		"\2\2\u00c3\u00c4\5$\23\2\u00c4\u00c5\5 \21\2\u00c5\u00c6\7\13\2\2\u00c6"+
		"\u00c7\5$\23\2\u00c7\u00c8\5 \21\2\u00c8\u0111\3\2\2\2\u00c9\u00ca\7#"+
		"\2\2\u00ca\u00cb\5$\23\2\u00cb\u00cc\5 \21\2\u00cc\u0111\3\2\2\2\u00cd"+
		"\u00cf\5\30\r\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3"+
		"\2\2\2\u00d0\u00d1\7$\2\2\u00d1\u00d2\5$\23\2\u00d2\u00d3\5\20\t\2\u00d3"+
		"\u0111\3\2\2\2\u00d4\u00d5\5\30\r\2\u00d5\u00d6\7%\2\2\u00d6\u00d7\5$"+
		"\23\2\u00d7\u00d8\7\13\2\2\u00d8\u00d9\5$\23\2\u00d9\u00dd\5 \21\2\u00da"+
		"\u00dc\5\32\16\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3"+
		"\2\2\2\u00dd\u00de\3\2\2\2\u00de\u0111\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e1\5\30\r\2\u00e1\u00e8\7&\2\2\u00e2\u00e9\7\'\2\2\u00e3\u00e9\7("+
		"\2\2\u00e4\u00e9\7)\2\2\u00e5\u00e9\7*\2\2\u00e6\u00e9\7+\2\2\u00e7\u00e9"+
		"\7,\2\2\u00e8\u00e2\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e8"+
		"\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00eb\5$\23\2\u00eb\u00ec\5 \21\2\u00ec\u00ed\5 \21\2\u00ed"+
		"\u0111\3\2\2\2\u00ee\u00ef\5\30\r\2\u00ef\u00f0\7-\2\2\u00f0\u00f1\5$"+
		"\23\2\u00f1\u00f2\7\13\2\2\u00f2\u00f3\5$\23\2\u00f3\u00f5\5 \21\2\u00f4"+
		"\u00f6\5\"\22\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u0111\3"+
		"\2\2\2\u00f7\u00f8\7.\2\2\u00f8\u00f9\5$\23\2\u00f9\u00fa\5 \21\2\u00fa"+
		"\u00fb\7\13\2\2\u00fb\u00fc\5$\23\2\u00fc\u00fe\5 \21\2\u00fd\u00ff\5"+
		"\"\22\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0111\3\2\2\2\u0100"+
		"\u0101\7/\2\2\u0101\u0103\5$\23\2\u0102\u0104\5 \21\2\u0103\u0102\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104\u0111\3\2\2\2\u0105\u0106\5\30\r\2\u0106"+
		"\u0107\7\60\2\2\u0107\u0108\5$\23\2\u0108\u010d\5\34\17\2\u0109\u010a"+
		"\7\13\2\2\u010a\u010c\5\34\17\2\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2"+
		"\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u0110\u0091\3\2\2\2\u0110\u0097\3\2\2\2\u0110\u00a9\3\2\2\2\u0110"+
		"\u00b1\3\2\2\2\u0110\u00b8\3\2\2\2\u0110\u00bf\3\2\2\2\u0110\u00c9\3\2"+
		"\2\2\u0110\u00ce\3\2\2\2\u0110\u00d4\3\2\2\2\u0110\u00e0\3\2\2\2\u0110"+
		"\u00ee\3\2\2\2\u0110\u00f7\3\2\2\2\u0110\u0100\3\2\2\2\u0110\u0105\3\2"+
		"\2\2\u0111\37\3\2\2\2\u0112\u0119\5*\26\2\u0113\u0119\5,\27\2\u0114\u0119"+
		"\7<\2\2\u0115\u0119\7=\2\2\u0116\u0119\7:\2\2\u0117\u0119\7;\2\2\u0118"+
		"\u0112\3\2\2\2\u0118\u0113\3\2\2\2\u0118\u0114\3\2\2\2\u0118\u0115\3\2"+
		"\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119!\3\2\2\2\u011a\u011b"+
		"\7\13\2\2\u011b\u011c\7\61\2\2\u011c\u011d\7>\2\2\u011d#\3\2\2\2\u011e"+
		"\u011f\b\23\1\2\u011f\u0122\5(\25\2\u0120\u0122\5&\24\2\u0121\u011e\3"+
		"\2\2\2\u0121\u0120\3\2\2\2\u0122\u0127\3\2\2\2\u0123\u0124\f\5\2\2\u0124"+
		"\u0126\7\62\2\2\u0125\u0123\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3"+
		"\2\2\2\u0127\u0128\3\2\2\2\u0128%\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b"+
		"\7\22\2\2\u012b\u012c\7>\2\2\u012c\u012d\7\63\2\2\u012d\u012e\5$\23\2"+
		"\u012e\u012f\7\23\2\2\u012f\'\3\2\2\2\u0130\u0131\t\2\2\2\u0131)\3\2\2"+
		"\2\u0132\u0136\7>\2\2\u0133\u0134\7\64\2\2\u0134\u0136\7>\2\2\u0135\u0132"+
		"\3\2\2\2\u0135\u0133\3\2\2\2\u0136+\3\2\2\2\u0137\u013b\7\65\2\2\u0138"+
		"\u013a\t\3\2\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"\u013f\7\66\2\2\u013f-\3\2\2\2\34\62\64<NV\\aehw\u0081\u0095\u00a2\u00ce"+
		"\u00dd\u00e8\u00f5\u00fe\u0103\u010d\u0110\u0118\u0121\u0127\u0135\u013b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}