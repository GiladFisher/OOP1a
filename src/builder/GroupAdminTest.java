package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GroupAdminTest {

    // Test below checks if a member exists in the GroupAdmin's members list (or doesn't).
    @Test
    public void RegisterDeleteTest()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder("TEST");
        GroupAdmin admin = new GroupAdmin(usb);

        ConcreteMember b = new ConcreteMember("Bella");

        admin.register(b);
        boolean flag1 = admin.members.contains(b);
        System.out.println(flag1);

        admin.unregister(b);
        boolean flag2 = admin.members.contains(b);
        System.out.println(flag2);

        assertTrue(flag1 && (!flag2));

    }

    // Test below checks if the size of the GroupAdmin's members ArrayList is as expected.
    @Test
    public void RegisterDeleteTest2()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder("TEST");
        GroupAdmin admin = new GroupAdmin(usb);

        ConcreteMember a = new ConcreteMember("Adam");
        ConcreteMember b = new ConcreteMember("Bella");
        ConcreteMember c = new ConcreteMember("Cliff");
        ConcreteMember d = new ConcreteMember("Dylan");
        ConcreteMember e = new ConcreteMember("Evelyn");

        admin.register(a);
        admin.register(b);
        admin.register(c);
        admin.register(d);
        admin.register(e);

        int size = admin.members.size();
        boolean flag1 = (size == 5);

        admin.unregister(a);
        admin.unregister(c);
        admin.unregister(e);

        size = admin.members.size();
        boolean flag2 = (size == 2);

        assertTrue(flag1 && flag2);
    }

    // Test below checks if the new members are all correctly observing the GroupAdmin (if they all have GroupAdmin's current UndoableStringBuilder).
    @Test
    public void UpdateTest()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder("TEST");
        GroupAdmin admin = new GroupAdmin(usb);

        ConcreteMember a = new ConcreteMember("Adam");
        ConcreteMember b = new ConcreteMember("Bella");
        ConcreteMember c = new ConcreteMember("Cliff");

        admin.register(a);
        admin.register(b);
        admin.register(c);

        assertEquals("TEST, TEST, TEST, TEST", admin.usb+", "+a.usb.toString()+", "+b.usb.toString()+", "+c.usb.toString() );
    }

    // Test below checks if a member that is no longer registered still gets updates from GroupAdmin.
    @Test
    public void UpdateTest2()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder("TEST");
        GroupAdmin admin = new GroupAdmin(usb);

        ConcreteMember a = new ConcreteMember("Adam");
        ConcreteMember b = new ConcreteMember("Bella");
        ConcreteMember c = new ConcreteMember("Cliff");

        admin.register(a);
        admin.register(b);
        admin.register(c);

        admin.unregister(b);
        System.out.println(admin.members.contains(b));

        admin.append(" TEST TEST");

        System.out.println(b.usb.toString());

        assertEquals("TEST", b.usb.toString());
    }
}
