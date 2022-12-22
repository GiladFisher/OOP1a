package builder;

public class ConcreteMember implements Member{
    UndoableStringBuilder usb; // this is the subject
    String name; // this is the name of the member
    GroupAdmin group; // this is the group that the member is in
    public ConcreteMember(String name){
        this.name = name;
        usb = new UndoableStringBuilder();
    }
    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }
}