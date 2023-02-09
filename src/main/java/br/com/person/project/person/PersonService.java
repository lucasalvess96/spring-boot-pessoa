package br.com.person.project.person;

import br.com.person.project.comon.EntityNotFoundExceptiion;
import br.com.person.project.person.DTO.PersonCreateDto;
import br.com.person.project.person.DTO.PersonDetailDto;
import br.com.person.project.person.DTO.PersonListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<PersonListDto> listPerson(Pageable pageable){
        Page<PersonEntity> personEntityPage = personRepository.findAll(pageable);
        return personEntityPage.map(PersonListDto::new);
    }

    public Optional<PersonDetailDto> detailPerson(Long id){
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        return personEntity.map(entity -> Optional.of(new PersonDetailDto(entity))).orElseThrow(() -> new EntityNotFoundExceptiion("id não encontrado"));
    }

    public PersonCreateDto createPerson(PersonCreateDto personCreateDto){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personCreateDto.getName());
        personEntity.setAge(personCreateDto.getAge());
        personEntity.setCpf(personCreateDto.getCpf());
        personEntity.setEmail(personCreateDto.getEmail());
        personEntity.setPassword(personCreateDto.getPassword());
        return new PersonCreateDto(personRepository.save(personEntity));
    }

    public PersonCreateDto updatePerson(Long id, PersonCreateDto personCreateDto){
        PersonEntity personEntity = personRepository.findById(id).get();
        personEntity.setName(personCreateDto.getName());
        personEntity.setAge(personCreateDto.getAge());
        personEntity.setCpf(personCreateDto.getCpf());
        personEntity.setEmail(personCreateDto.getEmail());
        personEntity.setPassword(personCreateDto.getPassword());
        return new PersonCreateDto(personRepository.save(personEntity));
    }

    public void deletePerson(Long id){
         personRepository.deleteById(id);

    }
}
