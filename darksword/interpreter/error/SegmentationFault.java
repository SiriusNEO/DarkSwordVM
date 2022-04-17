package darksword.interpreter.error;

import masterball.compiler.share.error.RuntimeError;

public class SegmentationFault extends RuntimeError {
    public SegmentationFault(String msg) {
        super("Segmentation Fault in: " + msg);
    }
}
