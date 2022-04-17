package darksword.interpreter.display;

import darksword.interpreter.generated.LLVMIRParser;

public class RowMark {
    public int row;
    public String code;

    public RowMark(int row, String code) {
        this.row = row;
        this.code = code;
    }
}
