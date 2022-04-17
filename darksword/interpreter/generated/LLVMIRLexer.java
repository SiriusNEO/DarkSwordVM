// Generated from ../src/darksword/interpreter/generated/LLVMIR.g4 by ANTLR 4.7.2

    package darksword.interpreter.generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLVMIRLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "IntType", "VoidType", "LabelType", "GlobalReg", 
			"LocalReg", "NullptrConstant", "BoolConstant", "IntegerLiteral", "Identifier", 
			"WhitespaceEater", "NewlineEater", "LineCommentEater", "EscapeEnter", 
			"EscapeBackslash", "EscapeQuote", "StringLiteral", "InfoStr"
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


	public LLVMIRLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LLVMIR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2G\u01ed\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3"+
		"\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3"+
		";\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u01b0\n<\3=\3=\3=\7=\u01b5\n=\f=\16"+
		"=\u01b8\13=\5=\u01ba\n=\3>\6>\u01bd\n>\r>\16>\u01be\3?\6?\u01c2\n?\r?"+
		"\16?\u01c3\3?\3?\3@\3@\5@\u01ca\n@\3@\5@\u01cd\n@\3@\3@\3A\3A\7A\u01d3"+
		"\nA\fA\16A\u01d6\13A\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3F\3F\7F\u01e7"+
		"\nF\fF\16F\u01ea\13F\3F\3F\3\u01e8\2G\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\u0087E\u0089F\u008bG\3\2\b\3\2\63;\3\2\62;\7\2\60\60\62;C\\a"+
		"ac|\4\2\13\13\"\"\4\2\f\f\17\17\3\2\"\u0080\2\u01f5\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3"+
		"\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2"+
		"\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087"+
		"\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u009d\3\2\2"+
		"\2\7\u009f\3\2\2\2\t\u00a6\3\2\2\2\13\u00b1\3\2\2\2\r\u00b8\3\2\2\2\17"+
		"\u00c8\3\2\2\2\21\u00cf\3\2\2\2\23\u00d1\3\2\2\2\25\u00d3\3\2\2\2\27\u00d5"+
		"\3\2\2\2\31\u00dd\3\2\2\2\33\u00e4\3\2\2\2\35\u00e6\3\2\2\2\37\u00e8\3"+
		"\2\2\2!\u00ea\3\2\2\2#\u00ec\3\2\2\2%\u00ee\3\2\2\2\'\u00f5\3\2\2\2)\u00f9"+
		"\3\2\2\2+\u00fd\3\2\2\2-\u0101\3\2\2\2/\u0106\3\2\2\2\61\u010b\3\2\2\2"+
		"\63\u010f\3\2\2\2\65\u0114\3\2\2\2\67\u0118\3\2\2\29\u011b\3\2\2\2;\u011f"+
		"\3\2\2\2=\u0127\3\2\2\2?\u012a\3\2\2\2A\u0130\3\2\2\2C\u0135\3\2\2\2E"+
		"\u0138\3\2\2\2G\u013d\3\2\2\2I\u014b\3\2\2\2K\u0150\3\2\2\2M\u0154\3\2"+
		"\2\2O\u0158\3\2\2\2Q\u015c\3\2\2\2S\u0160\3\2\2\2U\u0163\3\2\2\2W\u0166"+
		"\3\2\2\2Y\u016b\3\2\2\2[\u0171\3\2\2\2]\u0175\3\2\2\2_\u0179\3\2\2\2a"+
		"\u017f\3\2\2\2c\u0181\3\2\2\2e\u0183\3\2\2\2g\u0185\3\2\2\2i\u0188\3\2"+
		"\2\2k\u018d\3\2\2\2m\u0190\3\2\2\2o\u0195\3\2\2\2q\u019b\3\2\2\2s\u019e"+
		"\3\2\2\2u\u01a1\3\2\2\2w\u01af\3\2\2\2y\u01b9\3\2\2\2{\u01bc\3\2\2\2}"+
		"\u01c1\3\2\2\2\177\u01cc\3\2\2\2\u0081\u01d0\3\2\2\2\u0083\u01d9\3\2\2"+
		"\2\u0085\u01dc\3\2\2\2\u0087\u01df\3\2\2\2\u0089\u01e2\3\2\2\2\u008b\u01e4"+
		"\3\2\2\2\u008d\u008e\7u\2\2\u008e\u008f\7q\2\2\u008f\u0090\7w\2\2\u0090"+
		"\u0091\7t\2\2\u0091\u0092\7e\2\2\u0092\u0093\7g\2\2\u0093\u0094\7a\2\2"+
		"\u0094\u0095\7h\2\2\u0095\u0096\7k\2\2\u0096\u0097\7n\2\2\u0097\u0098"+
		"\7g\2\2\u0098\u0099\7p\2\2\u0099\u009a\7c\2\2\u009a\u009b\7o\2\2\u009b"+
		"\u009c\7g\2\2\u009c\4\3\2\2\2\u009d\u009e\7?\2\2\u009e\6\3\2\2\2\u009f"+
		"\u00a0\7v\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7i\2\2"+
		"\u00a3\u00a4\7g\2\2\u00a4\u00a5\7v\2\2\u00a5\b\3\2\2\2\u00a6\u00a7\7f"+
		"\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab"+
		"\7n\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7{\2\2\u00ad\u00ae\7q\2\2\u00ae"+
		"\u00af\7w\2\2\u00af\u00b0\7v\2\2\u00b0\n\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2"+
		"\u00b3\7t\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7r\2\2\u00b5\u00b6\7n\2\2"+
		"\u00b6\u00b7\7g\2\2\u00b7\f\3\2\2\2\u00b8\u00b9\7|\2\2\u00b9\u00ba\7g"+
		"\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be"+
		"\7p\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7k\2\2\u00c1"+
		"\u00c2\7c\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7|\2\2"+
		"\u00c5\u00c6\7g\2\2\u00c6\u00c7\7t\2\2\u00c7\16\3\2\2\2\u00c8\u00c9\7"+
		"i\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7d\2\2\u00cc\u00cd"+
		"\7c\2\2\u00cd\u00ce\7n\2\2\u00ce\20\3\2\2\2\u00cf\u00d0\7*\2\2\u00d0\22"+
		"\3\2\2\2\u00d1\u00d2\7.\2\2\u00d2\24\3\2\2\2\u00d3\u00d4\7+\2\2\u00d4"+
		"\26\3\2\2\2\u00d5\u00d6\7f\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7e\2\2\u00d8"+
		"\u00d9\7n\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2"+
		"\u00dc\30\3\2\2\2\u00dd\u00de\7f\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7"+
		"h\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7g\2\2\u00e3\32"+
		"\3\2\2\2\u00e4\u00e5\7}\2\2\u00e5\34\3\2\2\2\u00e6\u00e7\7\177\2\2\u00e7"+
		"\36\3\2\2\2\u00e8\u00e9\7<\2\2\u00e9 \3\2\2\2\u00ea\u00eb\7]\2\2\u00eb"+
		"\"\3\2\2\2\u00ec\u00ed\7_\2\2\u00ed$\3\2\2\2\u00ee\u00ef\7c\2\2\u00ef"+
		"\u00f0\7n\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f3\7e\2\2"+
		"\u00f3\u00f4\7c\2\2\u00f4&\3\2\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7f\2"+
		"\2\u00f7\u00f8\7f\2\2\u00f8(\3\2\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7"+
		"w\2\2\u00fb\u00fc\7d\2\2\u00fc*\3\2\2\2\u00fd\u00fe\7o\2\2\u00fe\u00ff"+
		"\7w\2\2\u00ff\u0100\7n\2\2\u0100,\3\2\2\2\u0101\u0102\7u\2\2\u0102\u0103"+
		"\7f\2\2\u0103\u0104\7k\2\2\u0104\u0105\7x\2\2\u0105.\3\2\2\2\u0106\u0107"+
		"\7u\2\2\u0107\u0108\7t\2\2\u0108\u0109\7g\2\2\u0109\u010a\7o\2\2\u010a"+
		"\60\3\2\2\2\u010b\u010c\7u\2\2\u010c\u010d\7j\2\2\u010d\u010e\7n\2\2\u010e"+
		"\62\3\2\2\2\u010f\u0110\7c\2\2\u0110\u0111\7u\2\2\u0111\u0112\7j\2\2\u0112"+
		"\u0113\7t\2\2\u0113\64\3\2\2\2\u0114\u0115\7c\2\2\u0115\u0116\7p\2\2\u0116"+
		"\u0117\7f\2\2\u0117\66\3\2\2\2\u0118\u0119\7q\2\2\u0119\u011a\7t\2\2\u011a"+
		"8\3\2\2\2\u011b\u011c\7z\2\2\u011c\u011d\7q\2\2\u011d\u011e\7t\2\2\u011e"+
		":\3\2\2\2\u011f\u0120\7d\2\2\u0120\u0121\7k\2\2\u0121\u0122\7v\2\2\u0122"+
		"\u0123\7e\2\2\u0123\u0124\7c\2\2\u0124\u0125\7u\2\2\u0125\u0126\7v\2\2"+
		"\u0126<\3\2\2\2\u0127\u0128\7v\2\2\u0128\u0129\7q\2\2\u0129>\3\2\2\2\u012a"+
		"\u012b\7v\2\2\u012b\u012c\7t\2\2\u012c\u012d\7w\2\2\u012d\u012e\7p\2\2"+
		"\u012e\u012f\7e\2\2\u012f@\3\2\2\2\u0130\u0131\7|\2\2\u0131\u0132\7g\2"+
		"\2\u0132\u0133\7z\2\2\u0133\u0134\7v\2\2\u0134B\3\2\2\2\u0135\u0136\7"+
		"d\2\2\u0136\u0137\7t\2\2\u0137D\3\2\2\2\u0138\u0139\7e\2\2\u0139\u013a"+
		"\7c\2\2\u013a\u013b\7n\2\2\u013b\u013c\7n\2\2\u013cF\3\2\2\2\u013d\u013e"+
		"\7i\2\2\u013e\u013f\7g\2\2\u013f\u0140\7v\2\2\u0140\u0141\7g\2\2\u0141"+
		"\u0142\7n\2\2\u0142\u0143\7g\2\2\u0143\u0144\7o\2\2\u0144\u0145\7g\2\2"+
		"\u0145\u0146\7p\2\2\u0146\u0147\7v\2\2\u0147\u0148\7r\2\2\u0148\u0149"+
		"\7v\2\2\u0149\u014a\7t\2\2\u014aH\3\2\2\2\u014b\u014c\7k\2\2\u014c\u014d"+
		"\7e\2\2\u014d\u014e\7o\2\2\u014e\u014f\7r\2\2\u014fJ\3\2\2\2\u0150\u0151"+
		"\7u\2\2\u0151\u0152\7i\2\2\u0152\u0153\7v\2\2\u0153L\3\2\2\2\u0154\u0155"+
		"\7u\2\2\u0155\u0156\7i\2\2\u0156\u0157\7g\2\2\u0157N\3\2\2\2\u0158\u0159"+
		"\7u\2\2\u0159\u015a\7n\2\2\u015a\u015b\7v\2\2\u015bP\3\2\2\2\u015c\u015d"+
		"\7u\2\2\u015d\u015e\7n\2\2\u015e\u015f\7g\2\2\u015fR\3\2\2\2\u0160\u0161"+
		"\7g\2\2\u0161\u0162\7s\2\2\u0162T\3\2\2\2\u0163\u0164\7p\2\2\u0164\u0165"+
		"\7g\2\2\u0165V\3\2\2\2\u0166\u0167\7n\2\2\u0167\u0168\7q\2\2\u0168\u0169"+
		"\7c\2\2\u0169\u016a\7f\2\2\u016aX\3\2\2\2\u016b\u016c\7u\2\2\u016c\u016d"+
		"\7v\2\2\u016d\u016e\7q\2\2\u016e\u016f\7t\2\2\u016f\u0170\7g\2\2\u0170"+
		"Z\3\2\2\2\u0171\u0172\7t\2\2\u0172\u0173\7g\2\2\u0173\u0174\7v\2\2\u0174"+
		"\\\3\2\2\2\u0175\u0176\7r\2\2\u0176\u0177\7j\2\2\u0177\u0178\7k\2\2\u0178"+
		"^\3\2\2\2\u0179\u017a\7c\2\2\u017a\u017b\7n\2\2\u017b\u017c\7k\2\2\u017c"+
		"\u017d\7i\2\2\u017d\u017e\7p\2\2\u017e`\3\2\2\2\u017f\u0180\7,\2\2\u0180"+
		"b\3\2\2\2\u0181\u0182\7z\2\2\u0182d\3\2\2\2\u0183\u0184\7/\2\2\u0184f"+
		"\3\2\2\2\u0185\u0186\7e\2\2\u0186\u0187\7$\2\2\u0187h\3\2\2\2\u0188\u0189"+
		"\7^\2\2\u0189\u018a\7\62\2\2\u018a\u018b\7\62\2\2\u018b\u018c\7$\2\2\u018c"+
		"j\3\2\2\2\u018d\u018e\7k\2\2\u018e\u018f\5y=\2\u018fl\3\2\2\2\u0190\u0191"+
		"\7x\2\2\u0191\u0192\7q\2\2\u0192\u0193\7k\2\2\u0193\u0194\7f\2\2\u0194"+
		"n\3\2\2\2\u0195\u0196\7n\2\2\u0196\u0197\7c\2\2\u0197\u0198\7d\2\2\u0198"+
		"\u0199\7g\2\2\u0199\u019a\7n\2\2\u019ap\3\2\2\2\u019b\u019c\7B\2\2\u019c"+
		"\u019d\5{>\2\u019dr\3\2\2\2\u019e\u019f\7\'\2\2\u019f\u01a0\5{>\2\u01a0"+
		"t\3\2\2\2\u01a1\u01a2\7p\2\2\u01a2\u01a3\7w\2\2\u01a3\u01a4\7n\2\2\u01a4"+
		"\u01a5\7n\2\2\u01a5v\3\2\2\2\u01a6\u01a7\7v\2\2\u01a7\u01a8\7t\2\2\u01a8"+
		"\u01a9\7w\2\2\u01a9\u01b0\7g\2\2\u01aa\u01ab\7h\2\2\u01ab\u01ac\7c\2\2"+
		"\u01ac\u01ad\7n\2\2\u01ad\u01ae\7u\2\2\u01ae\u01b0\7g\2\2\u01af\u01a6"+
		"\3\2\2\2\u01af\u01aa\3\2\2\2\u01b0x\3\2\2\2\u01b1\u01ba\7\62\2\2\u01b2"+
		"\u01b6\t\2\2\2\u01b3\u01b5\t\3\2\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2"+
		"\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8"+
		"\u01b6\3\2\2\2\u01b9\u01b1\3\2\2\2\u01b9\u01b2\3\2\2\2\u01baz\3\2\2\2"+
		"\u01bb\u01bd\t\4\2\2\u01bc\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bc"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf|\3\2\2\2\u01c0\u01c2\t\5\2\2\u01c1"+
		"\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\b?\2\2\u01c6~\3\2\2\2\u01c7\u01c9"+
		"\7\17\2\2\u01c8\u01ca\7\f\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2"+
		"\u01ca\u01cd\3\2\2\2\u01cb\u01cd\7\f\2\2\u01cc\u01c7\3\2\2\2\u01cc\u01cb"+
		"\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\b@\2\2\u01cf\u0080\3\2\2\2\u01d0"+
		"\u01d4\7=\2\2\u01d1\u01d3\n\6\2\2\u01d2\u01d1\3\2\2\2\u01d3\u01d6\3\2"+
		"\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d7\u01d8\bA\2\2\u01d8\u0082\3\2\2\2\u01d9\u01da\7^\2"+
		"\2\u01da\u01db\7p\2\2\u01db\u0084\3\2\2\2\u01dc\u01dd\7^\2\2\u01dd\u01de"+
		"\7^\2\2\u01de\u0086\3\2\2\2\u01df\u01e0\7^\2\2\u01e0\u01e1\7$\2\2\u01e1"+
		"\u0088\3\2\2\2\u01e2\u01e3\t\7\2\2\u01e3\u008a\3\2\2\2\u01e4\u01e8\7$"+
		"\2\2\u01e5\u01e7\5\u0089E\2\u01e6\u01e5\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8"+
		"\u01e9\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e8\3\2"+
		"\2\2\u01eb\u01ec\7$\2\2\u01ec\u008c\3\2\2\2\f\2\u01af\u01b6\u01b9\u01be"+
		"\u01c3\u01c9\u01cc\u01d4\u01e8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}