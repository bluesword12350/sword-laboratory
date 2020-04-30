package top.bluesword.web.laboratory.mock;

import top.bluesword.web.laboratory.domain.person.FullName;
import top.bluesword.web.laboratory.domain.person.Person;

import java.util.ArrayList;
import java.util.List;

public final class PersonMock {

    public static List<Person> mockList(){
        List<Person> people = new ArrayList<>();
        people.add(mock());
        return people;
    }

    private static Person mock() {
        Person person = new Person();
        person.setFullName(mockFullName());
        return person;
    }

    private static FullName mockFullName() {
        FullName fullName = new FullName();
        fullName.setSurname("李");
        fullName.setName("林峰");
        return fullName;
    }

}
