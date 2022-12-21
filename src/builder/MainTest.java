package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void toStringTest(){
        UndoableStringBuilder s = new UndoableStringBuilder("test");
        assertEquals("test", s.toString());
    }
    @Test
    public void reverseTest(){
        UndoableStringBuilder s = new UndoableStringBuilder("123");
        s.reverse();
        assertEquals("321", s.toString());
    }
    @Test
    public void appendTest(){
        UndoableStringBuilder s = new UndoableStringBuilder("a");
        s.append("v \t \n b");
        assertEquals("a"+"v \t \n b",s.toString());
    }
    @Test
    public void reverseTestEmpty(){
        UndoableStringBuilder s = new UndoableStringBuilder("");
        s.reverse();
        assertEquals("", s.toString());
    }
    @Test
    public void deleteTest(){
        UndoableStringBuilder s = new UndoableStringBuilder("123");
        s.delete(1,2);
        s.delete(-1,5);
        s.delete(1,0);
        assertEquals("13",s.toString());

    }
    @Test
    public void insertTest(){
        UndoableStringBuilder s = new UndoableStringBuilder("145");
        s.insert(1,"23");
        s.insert(7, "a");
        s.insert(-1, "a");
        assertEquals("12345", s.toString());
    }
    @Test
    public void replaceTest(){

        UndoableStringBuilder sb = new UndoableStringBuilder("Peanut Butter");

        //Replacing one letter
        UndoableStringBuilder sb1 = new UndoableStringBuilder("Peanut Butler");
        assertEquals(sb1.toString(), sb.replace(10,11, "l").toString());

        //Equivalent action to delete expected.
        UndoableStringBuilder sb2 = new UndoableStringBuilder("Peanut");
        assertEquals(sb2.toString(), sb.replace(6,13, "").toString());

        //No change expected
        assertEquals(sb.toString(), sb.replace(6,17, "asdf").toString());
    }


    @Test
    public void undoTest(){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.undo();
        assertEquals("", s.toString());
        s.append("1");
        s.undo();
        assertEquals("", s.toString());
        s.append("123");
        s.delete(1,2);
        assertEquals("13", s.toString());
        s.undo();
        assertEquals("123", s.toString());
        s.undo();
        assertEquals("", s.toString());
        s.undo();
        s = new UndoableStringBuilder("abcd");
        s.replace(1,2,"2");
        assertEquals("a2cd", s.toString());
        s.insert(2,".");
        assertEquals("a2.cd", s.toString());
        s.reverse();
        assertEquals("dc.2a", s.toString());
        s.undo();
        assertEquals("a2.cd", s.toString());
        s.undo();
        assertEquals("a2cd", s.toString());
        s.undo();
        assertEquals("abcd", s.toString());
    }

}