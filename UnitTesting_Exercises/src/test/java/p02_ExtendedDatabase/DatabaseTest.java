package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PERSON_LIST = {new Person(1, "First"), new Person(2, "Second"), new Person(3, "Third")};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PERSON_LIST);

    }

    @Test
    public void testConstructorHasToCreateValidObject() {

        Assert.assertEquals(PERSON_LIST.length, database.getElements().length);
        Assert.assertEquals(PERSON_LIST.length - 1, database.getElements().length - 1);
        Assert.assertArrayEquals(PERSON_LIST, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorOverSixteen() throws OperationNotSupportedException {
        Person[] person = new Person[17];
        new Database(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorUnderOne() throws OperationNotSupportedException {
        Person[] person = new Person[0];
        new Database(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNull() throws OperationNotSupportedException {
        Person person = null;
        database.add(person);


    }

    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        Person person = new Person(4, "Sasho");
        database.add(person);

        Assert.assertEquals(PERSON_LIST.length + 1, database.getElements().length);
        Assert.assertEquals(PERSON_LIST.length + 1, database.getElements()[3].getId());
    }


    @Test(expected = OperationNotSupportedException.class)
    public void removeNull() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();


    }

    @Test
    public void removePerson() throws OperationNotSupportedException {

        database.remove();

        Assert.assertEquals(PERSON_LIST.length - 1, database.getElements().length);
        Assert.assertEquals(PERSON_LIST.length - 1, database.getElements()[1].getId());

    }

    @Test
    public void findByName() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameNull()
            throws OperationNotSupportedException {
        database.findByUsername(null);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameIfSizeIsNotOne()
            throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("First");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findByUsername("First");
    }


    @Test
    public void findById() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());

    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdIfSizeIsNotOne()
            throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findById(1);
    }

}