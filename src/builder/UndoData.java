package builder;

public class UndoData {
    enum Method{ // These will later be used to determine which action is needed
        DEL, REP, REV, INS;
        // DEL = delete, REP = replace, REV = reverse, INS = insert
    }

    Method m;
    int start = -1, end = -1;
    String str;

    public UndoData(Method M, int start,int end, String str){
        m = M;
        this.start = start;
        this.end = end;
        this.str = str;
    }
    // no other builders needed because we can just ignore redundant variables
}
