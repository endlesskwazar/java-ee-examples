package jstl.beans.service;

import java.util.List;

import jstl.beans.domain.Person;
import jstl.beans.repository.PersonRepository;

public class PersonService {

	private PersonRepository personRepository;
	
	public PersonService() {
		personRepository = new PersonRepository();
	}
	
	public List<Person> getAll(){
		return personRepository.getAll();
	}
	
	public Person add(Person entity) {
		return personRepository.add(entity);
	}
	
}
