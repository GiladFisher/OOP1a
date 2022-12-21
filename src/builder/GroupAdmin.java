package builder;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    ArrayList<Member> members = new ArrayList<Member>();
    UndoableStringBuilder usb = new UndoableStringBuilder();

    @Override
    public void register(Member obj) {
        // TODO Auto-generated method stub
        members.add(obj);
        
    }

    @Override
    public void unregister(Member obj) {
        // TODO Auto-generated method stub
        members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
// TODO Auto-generated method stub
        usb.insert(offset, obj);


    }

    @Override
    public void append(String obj) {

    }

    @Override
    public void delete(int start, int end) {

    }

    @Override
    public void undo() {

    }
}
