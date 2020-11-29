package ru.klabukova.springcourse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ru.klabukova.springcourse.models.Person;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;
	private List<Person> people;
	
	{
		people = new ArrayList<Person>();
		
		people.add(new Person(++PEOPLE_COUNT, "Ned", 24, "ned@mail.ru"));
		people.add(new Person(++PEOPLE_COUNT, "Tom", 30, "tom@yandex.ru"));
		people.add(new Person(++PEOPLE_COUNT, "Bob", 38, "bob@gmail.com"));
		people.add(new Person(++PEOPLE_COUNT, "Mike", 21, "mike@yahoo.com"));
	}
	
	public List<Person> index() {
		return people;
	}
	
	public Person show(int id) {
		return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
	}
	
	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}
	
	public void update(int id, Person person) {
		Person personToBeUpd = show(id);
		personToBeUpd.setName(person.getName());
		personToBeUpd.setAge(person.getAge());
		personToBeUpd.setEmail(person.getEmail());
	}

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

}
