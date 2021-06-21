package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testConstructorHasToCreateValidObject()
            throws OperationNotSupportedException {
        Integer[] numbers = {5, 9, 29, 45, 54, 63, 98, 102};
        Database database = new Database(numbers);
        Assert.assertEquals(numbers.length, database.getElements().length);
        Assert.assertEquals(numbers.length - 1, database.getElements().length - 1);
        Assert.assertArrayEquals(numbers, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorOverSixteen() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorUnderOne() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNull() throws OperationNotSupportedException {
        Integer n = null;
        Database database = new Database(1, 2, 3);
        database.add(n);

    }

    @Test
    public void testAddNumber() throws OperationNotSupportedException {
        Integer n = 1;
        Database database = new Database(1, 2, 3);
        database.add(n);
        Integer[] test = {1, 2, 3, 1};
        Assert.assertEquals(4, database.getElements().length);
        Assert.assertArrayEquals(test, database.getElements());
    }


    @Test(expected = OperationNotSupportedException.class)
    public void removeNull() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();

    }
    @Test
    public void removeNum() throws OperationNotSupportedException {
        Database database = new Database(1,2,3,4);
        database.remove();
        Integer[] test = {1, 2, 3};
        Assert.assertEquals(test.length, database.getElements().length);
        Assert.assertArrayEquals(test, database.getElements());

    }


}