package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
    Owner findById(Long id);
    Owner findByLastname(String lastName);
}
