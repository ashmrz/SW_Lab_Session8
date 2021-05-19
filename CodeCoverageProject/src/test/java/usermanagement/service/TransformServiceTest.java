package usermanagement.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import usermanagement.entity.Person;

public class TransformServiceTest {

    private TransformService testClass = new TransformService();

    @Test
    public void test_toUserDomain() {
        Person testPerson = new Person();
        testPerson.setfName("fName");
        testPerson.setmName("mName");
        testPerson.setlName("lName");
        testPerson.setCompanyName("companyName");
        testPerson.setPersonId(1);

        User testUser1 = testClass.toUserDomain(testPerson);

        User testUser2 = new User();
        testUser2.setFirstName(testPerson.getfName());
        testUser2.setLastName(testPerson.getlName());
        testUser2.setUserId(testPerson.getPersonId());
        testUser2.setCompanyName(testPerson.getCompanyName());

        assertEquals(true, testUser1.equals(testUser2));

        assertEquals(testUser1.getFirstName(), testUser2.getFirstName());
        assertEquals(testUser1.getLastName(), testUser2.getLastName());
        assertEquals(testUser1.getCompanyName(), testUser2.getCompanyName());
        assertEquals(testUser1.getUserId(), testUser2.getUserId());

        assertEquals(testUser1.hashCode(), testUser2.hashCode());
    }

    @Test
    public void test_toUserEntity() {
        User testUser = new User();
        testUser.setFirstName("fName");
        testUser.setLastName("lName");
        testUser.setCompanyName("companyName");
        testUser.setUserId(1);

        Person testPerson1 = testClass.toUserEntity(testUser);

        Person testPerson2 = new Person();
        testPerson2.setfName(testUser.getFirstName());
        testPerson2.setlName(testUser.getLastName());
        testPerson2.setPersonId(testUser.getUserId());
        testPerson2.setCompanyName(testUser.getCompanyName());

        assertEquals(testPerson1.getfName(), testPerson2.getfName());
        assertEquals(testPerson1.getlName(), testPerson2.getlName());
        assertEquals(testPerson1.getCompanyName(), testPerson2.getCompanyName());
        assertEquals(testPerson1.getPersonId(), testPerson2.getPersonId());

    }

    @Test
    public void test_specificCases() {
        User testUser = new User();
        testUser.setFirstName("fName");
        testUser.setLastName("lName");
        testUser.setCompanyName("companyName");
        testUser.setUserId(1);

        User testUser2 = new User();
        testUser2.setFirstName("fName");
        testUser2.setLastName("lName");
        testUser2.setCompanyName("companyName");
        testUser2.setUserId(2);

        User testUser3 = new User();
        testUser3.setFirstName("fName");
        testUser3.setLastName("lName");
        testUser3.setCompanyName("companyName");
        testUser3.setUserId(null);


        assertNotEquals(true, testUser.equals(null));
        assertEquals(true, testUser.equals(testUser));
        assertEquals(false, testUser.equals(new Person()));
        assertEquals(false, testUser.equals(testUser2));
        assertEquals(false, testUser3.equals(testUser));
    }
}

