package com.cristian.tiusers.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@DisplayName("Testing user entity")
class UserTest {

    @Test
     void testEquals() {
        User user1 = new User(1, "John", "Doe", "Address 1", "123456789", "Manager", "City 1", true, null, null);
        User user2 = new User(1, "John", "Doe", "Address 1", "123456789", "Manager", "City 1", true, null, null);

        assertEquals(user1, user2);
    }

    @Test
    void testNotEquals() {
        User user1 = new User(1, "John", "Doe", "Address 1", "123456789", "Manager", "City 1", true, null, null);
        User user2 = new User(2, "Jane", "Smith", "Address 2", "987654321", "Employee", "City 2", false, null, null);

        assertNotEquals(user1, user2);
    }

    @Test
    void testHashCode() {
        User user = new User(1, "John", "Doe", "Address 1", "123456789", "Manager", "City 1", true, null, null);
        assertEquals(user.hashCode(), user.hashCode());
    }

    @Test
    void testCompanyAssociation() {
        Company companyMock = mock(Company.class);
        User user = new User(1, "John", "Doe", "Address 1", "123456789", "Manager", "City 1", true, companyMock, null);
        assertEquals(companyMock, user.getCompany());
    }

    @Test
    void testDepartmentAssociation() {
        Department departmentMock = mock(Department.class);
        User user = new User(1, "John", "Doe", "Address 1", "123456789", "Manager", "City 1", true, null, departmentMock);
        assertEquals(departmentMock, user.getDepartment());
    }
}