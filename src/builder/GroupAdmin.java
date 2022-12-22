package builder;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    ArrayList<Member> members;
    UndoableStringBuilder usb;

    public GroupAdmin()
    {
        this.members = new ArrayList<Member>();
        this.usb = new UndoableStringBuilder();
    }

    public GroupAdmin(UndoableStringBuilder usb)
    {
        this.members = new ArrayList<Member>();
        this.usb = usb;
    }

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
        ((ConcreteMember) obj).group = null;
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
