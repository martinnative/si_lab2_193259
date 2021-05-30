import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    Time test1 = new Time (5,5,5);
    Time test2 = new Time (-1,5,5);
    Time test3 = new Time (25,5,5);
    Time test4 = new Time (5,-1,5);
    Time test5 = new Time (5,5,-1);
    Time test6 = new Time (24,0,0);
    Time test7 = new Time (24,3,2);

    private List <Time> createList  (Time ... elems){
        return new ArrayList<Time>(Arrays.asList(elems));
    }
    private List <Integer> createListINT  (Integer ... elems){
        return new ArrayList<Integer>(Arrays.asList(elems));
    }


    @Test // Every Branch
    void everyStatementTest(){
        assertEquals(createListINT(18305), SILab2.function(createList(test1)));
        assertEquals(createListINT(86400), SILab2.function(createList(test6)));
        RuntimeException ex;
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(test2)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(test3)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(test4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(test5)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

       ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(test7)));
       assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }
    // Multiple condition
    // if(hr<0 || hr>24)
       // T || X
       Time Mtest1 = new Time (-1,5,5);
       // F || T
       Time Mtest2 = new Time (25,5,5);
       // F || F
       Time Mtest3 = new Time (12,5,5);
       // if (min < 0 || min > 59)
        // T || X
       Time Mtest4 = new Time (1,-1,5);
       // F || T
       Time Mtest5 = new Time (1,60,5);
        // F || F
        Time Mtest6 = new Time (1,5,5);

        // if (sec >= 0 && sec <= 59)
    // T && T
        Time Mtest7 = new Time (1,5,5);
    // T && F
    Time Mtest8 = new Time (1,5,60);
    // F && X
    Time Mtest9= new Time (1,5,-1);

    //if (hr == 24 && min == 0 && sec == 0)
    // T && T && T
    Time Mtest10 = new Time (24,0,0);
    // T && T && F
    Time Mtest11 = new Time (24,0,1);
    // T  && F && X
    Time Mtest12 = new Time (24,1,0);
    // F && X && X
    Time Mtest13 = new Time (24,7,8);

    @Test
    void multipleConditionTest(){
        RuntimeException ex;
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        // assertTrue(true, SILab2.function(createList(Mtest3)));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest5)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
      //mtest6 ,7

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest8)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest9)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        //mtest 10

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest11)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest12)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

       //  mora da vleze so 24 , inaku vlaga vo drugi ifovi
        ex =  assertThrows(RuntimeException.class, () -> SILab2.function(createList(Mtest13)));
        assertEquals(true, ex.getMessage().contains("The time is greater than the maximum"));
    }


}