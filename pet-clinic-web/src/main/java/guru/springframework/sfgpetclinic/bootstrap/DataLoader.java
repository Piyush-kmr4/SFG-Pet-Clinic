package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        System.out.println("Loaded Pets...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Piyush");
        owner1.setLastName("Kumar");
        owner1.setAddress("Gosaipara, Agriculture Farm");
        owner1.setCity("Burdwan");
        owner1.setTelephone("7988576448");

        Pet teddy = new Pet();
        teddy.setName("Teddy");
        teddy.setBirthDate(LocalDate.now());
        teddy.setOwner(owner1);
        teddy.setPetType(savedDog);
        owner1.getPets().add(teddy);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Akshay");
        owner2.setLastName("Kumar");
        owner2.setAddress("Gosaipara, Agriculture Farm");
        owner2.setCity("Burdwan");
        owner2.setTelephone("7988576448");

        Pet newCat = new Pet();
        newCat.setName("Maria");
        newCat.setOwner(owner2);
        newCat.setBirthDate(LocalDate.now());
        newCat.setPetType(savedCat);
        owner2.getPets().add(newCat);

        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Vet vet1 =  new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Brooks");

        vetService.save(vet1);

        Vet vet2 =  new Vet();
        vet2.setFirstName("Champ");
        vet2.setLastName("Lucy");

        vetService.save(vet2);
        System.out.println("Loaded Vets....");


    }
}
