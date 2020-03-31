package marko.andrushchenko.networklab1.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class PersonRepositoryImpl implements PersonRepository {
	@Override
	public Person getPerson(int Id) {
		return System.persons.get(Id);
	}

	@Override
	public Set<Map.Entry<Integer, Person>> getPersons() {
		return  System.persons.entrySet();
	}

	@Override
	public Person updatePerson(int Id, Person person) {
		System.persons.replace(Id, person);
		return System.persons.get(Id);
	}

	@Override
	public boolean deletePerson(int Id) {
		try {
			System.persons.remove(Id);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	@Override
	public boolean createPerson(Person person) {
		System.persons.put(++System.lastId,person);
		return true;
	}
}
