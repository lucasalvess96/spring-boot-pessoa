package br.com.person.project.person;

import br.com.person.project.address.AddressDto;
import br.com.person.project.address.AddressEntity;
import br.com.person.project.address.AddressRepository;
import br.com.person.project.comon.EntityNotFoundExceptiion;
import br.com.person.project.person.DTO.PersonCreateDto;
import br.com.person.project.person.DTO.PersonDetailDto;
import br.com.person.project.person.DTO.PersonListDto;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;

    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public Page<PersonListDto> listPerson(Pageable pageable){
        Page<PersonEntity> personEntityPage = personRepository.findAll(pageable);
        return personEntityPage.map(PersonListDto::new);
    }

    public Optional<PersonDetailDto> detailPerson(Long id){
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        return personEntity
                .map(entity -> Optional.of(new PersonDetailDto(entity)))
                .orElseThrow(() -> new EntityNotFoundExceptiion("id não encontrado"));
    }

    public PersonCreateDto createPerson(PersonCreateDto personCreateDto){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personCreateDto.getName());
        personEntity.setAge(personCreateDto.getAge());
        personEntity.setCpf(personCreateDto.getCpf());
        personEntity.setEmail(personCreateDto.getEmail());
        personEntity.setPassword(personCreateDto.getPassword());

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(personCreateDto.getAddressEntity().getStreet());
        addressEntity.setNumber(personCreateDto.getAddressEntity().getNumber());
        addressEntity.setCity(personCreateDto.getAddressEntity().getCity());

        personEntity.setAddress(addressRepository.save(addressEntity));
        return new PersonCreateDto(personRepository.save(personEntity));
    }

    public PersonCreateDto updatePerson(Long id, PersonCreateDto personCreateDto) {
        PersonEntity personEntity = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundExceptiion("id não encontrado"));
        personEntity.setName(personCreateDto.getName());
        personEntity.setAge(personCreateDto.getAge());
        personEntity.setCpf(personCreateDto.getCpf());
        personEntity.setEmail(personCreateDto.getEmail());
        personEntity.setPassword(personCreateDto.getPassword());
        return new PersonCreateDto(personRepository.save(personEntity));
    }

    public Page<PersonEntity> searchPerson(String name, Pageable page) {
        if(StringUtils.isBlank(name)) return personRepository.findAll(page);
        return personRepository.findAllByNameContainingIgnoreCase(name, page);
    }

    public void deletePerson(Long id) {
        if(personRepository.existsById(id)){
            personRepository.deleteById(id);
        }
        throw new EntityNotFoundExceptiion("id não encontrado");
    }
}
