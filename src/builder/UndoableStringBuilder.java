package builder;
import java.lang.StringBuilder;
import java.util.Stack;

/**
 *  This class will allow the user to use the regular append, delete, reverse, insert, toString and replace methods that are known from StringBuilder. But, wiil also allow the user to undo changes they made to the text
 */

public class UndoableStringBuilder {

    private Stack<UndoData> history; // FILO is perfect for this
    private StringBuilder sb;

    /**
     * This is the default builder that doesn't require any parameters
     */

    public UndoableStringBuilder(){
        sb = new StringBuilder();
        history = new Stack<>();
    }

    /**
     * This builder uses a String to initiate a StringBuilder
     * @param str
     */

    public UndoableStringBuilder(String str){
        sb = new StringBuilder(str);
        history = new Stack<>();
    }

    /**
     * This method adds the given String to the end of the existing one
     * @param str
     * @return UndoableStringBuilder
     */

    public UndoableStringBuilder append(String str){
        UndoData u = new UndoData(UndoData.Method.DEL, sb.toString().length(), sb.toString().length() + str.length(), "");
        history.push(u);
        sb.append(str);
        return this;
    }

    /**
     * This method removes the characters between the two indexes provided
     * @param start
     * @param end
     * @return UndoableStringBuilder
     */

    public UndoableStringBuilder delete(int start, int end){
        try{
            if(start < 0 || end > sb.length() || start > sb.length() || end < 0){
                throw new StringIndexOutOfBoundsException("input index / indexes out of bounds");
            }
            else if(start > end){
                throw new StringIndexOutOfBoundsException("start value is bigger than end value");
            }
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("returning last value");
            return this;
        }
        UndoData u = new UndoData(UndoData.Method.INS, start, -1 , sb.substring(start,end));
        history.push(u);
        sb.delete(start, end);
        return this;
    }

    /**
     * This method inserts the given String at the index provided
     * @param offset
     * @param str
     * @return UndoableStringBuilder
     */

    public UndoableStringBuilder insert(int offset, String str){
        try{
            if(offset < 0 || offset > sb.length()){
                throw new StringIndexOutOfBoundsException("input index / indexes out of bounds");
            }
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("returning last value");
            return this;
        }
        UndoData u = new UndoData(UndoData.Method.DEL, offset, offset + str.length() ,"");
        history.push(u);
        sb.insert(offset, str);
        return this;
    }

    /**
     * this method deletes the characters between the two indexes provided and inserts the given String at the smaller index
     * @param start
     * @param end
     * @param str
     * @return UndoableStringBuilder
     */

    public UndoableStringBuilder replace(int start,int end, String str){
        try{
            if(start < 0 || end > sb.length() || start > sb.length() || end < 0){
                throw new StringIndexOutOfBoundsException("input index / indexes out of bounds");
            }
            else if(start > end){
                throw new StringIndexOutOfBoundsException("start value is bigger than end value");
            }
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("returning last value");
            return this;
        }
        UndoData u = new UndoData(UndoData.Method.REP, start, start + str.length(), sb.substring(start, end));
        history.push(u);
        sb.replace(start, end, str);
        return this;
    }

    /**
     * This method reverses the sequence of characters in the StringBuilder
     * @return UndoableStringBuilder
     */

    public UndoableStringBuilder reverse(){
        UndoData u = new UndoData(UndoData.Method.REV, -1, -1, "");
        history.push(u);
        sb.reverse();
        return this;
    }

    /**
     * This method uses the history of actions performed on a StringBuilder to perform the opposite actions in order to get to the value before each action
     * @return UndoableStringBuilder
     */

    public UndoableStringBuilder undo(){
        if(history.empty()) {
            System.out.println("No actions to undo");
            return this;
        }
        UndoData un = history.pop();

        switch (un.m){
            case REV:
                sb.reverse();
                break;
            case DEL:
                sb.delete(un.start, un.end);
                break;
            case INS:
                sb.insert(un.start, un.str);
                break;
            case REP:
                sb.replace(un.start, un.end, un.str);
                break;
        }
        return this;
    }

    public String toString(){
        return sb.toString();
    }
}