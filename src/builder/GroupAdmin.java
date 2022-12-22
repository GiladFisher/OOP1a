package builder;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    ArrayList<Member> members = new ArrayList<>();
    UndoableStringBuilder usb = new UndoableStringBuilder();

    @Override
    public void register(Member obj) {
        members.add(obj);
        ((ConcreteMember) obj).group = this;
        for (Member member : members) {
            member.update(usb);
        }
    }

    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        usb.insert(offset, obj);
        for (Member member : members) {
            member.update(usb);
        }
    }

    @Override
    public void append(String obj) {
        usb.append(obj);
        for (Member member : members) {
            member.update(usb);
        }
    }

    @Override
    public void delete(int start, int end) {
        usb.delete(start, end);
        for (Member member : members) {
            member.update(usb);
        }
    }

    @Override
    public void undo() {
        usb.undo();
        for (Member member : members) {
            member.update(usb);
        }
    }
}
