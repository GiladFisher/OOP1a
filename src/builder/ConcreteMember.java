package builder;

public class ConcreteMember implements Member{
    UndoableStringBuilder usb;
    String name;
    GroupAdmin group;

    @Override
    public void update(UndoableStringBuilder usb) {
        this.usb = usb;
    }
}

