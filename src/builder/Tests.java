package builder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    public void testUsb(){
        UndoableStringBuilder usb = new UndoableStringBuilder("TEST");
        logger.info(()->JvmUtilities.objectFootprint(usb));
        usb.append("TESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTEST");
        logger.info(()->JvmUtilities.objectFootprint(usb));
        usb.insert(2,"abcdefg");
        logger.info(()->JvmUtilities.objectTotalSize(usb));
        logger.info(()->JvmUtilities.jvmInfo());

    }
    @Test
    public void testGroupAdmin(){
        UndoableStringBuilder usb = new UndoableStringBuilder("TEST");
        GroupAdmin admin = new GroupAdmin(usb);
        ConcreteMember b = new ConcreteMember("Yekutiel");
        admin.register(b);
        admin.unregister(b);
        logger.info(()->JvmUtilities.objectFootprint(admin));
        logger.info(()->JvmUtilities.objectTotalSize(admin));
        logger.info(()->JvmUtilities.objectFootprint(b));
        logger.info(()->JvmUtilities.objectTotalSize(b));

        logger.info(()->JvmUtilities.jvmInfo());
    }
    @Test
    public void testGroupAdmin2(){
        UndoableStringBuilder usb = new UndoableStringBuilder("TEST");
        GroupAdmin admin = new GroupAdmin(usb);
        ConcreteMember a = new ConcreteMember("Menahem");
        ConcreteMember b = new ConcreteMember("Yotam");
        ConcreteMember c = new ConcreteMember("Yafa");
        ConcreteMember d = new ConcreteMember("Nava");
        ConcreteMember e = new ConcreteMember("Evyatar");
        admin.register(a);
        admin.register(b);
        admin.register(c);
        admin.register(d);
        admin.register(e);

        logger.info(()->JvmUtilities.objectFootprint(admin));

        admin.unregister(a);
        admin.unregister(c);
        admin.unregister(e);

        logger.info(()->JvmUtilities.objectTotalSize(admin));

        logger.info(()->JvmUtilities.objectFootprint(a));
        logger.info(()->JvmUtilities.objectTotalSize(a));
        logger.info(()->JvmUtilities.objectFootprint(b));
        logger.info(()->JvmUtilities.objectTotalSize(b));
        logger.info(()->JvmUtilities.objectFootprint(c));
        logger.info(()->JvmUtilities.objectTotalSize(c));
        logger.info(()->JvmUtilities.objectFootprint(d));
        logger.info(()->JvmUtilities.objectTotalSize(d));
        logger.info(()->JvmUtilities.objectFootprint(e));
        logger.info(()->JvmUtilities.objectTotalSize(e));

        logger.info(()->JvmUtilities.jvmInfo());
    }
}
