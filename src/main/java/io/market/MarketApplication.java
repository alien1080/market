package io.market;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MarketApplication {

    @Autowired
    public EmployeeRepository repository;

    @Autowired
    public MascotaRepository repositorym;
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employe){
        System.out.println(employe.toString());
        return repository.save(employe);
    }
    @DeleteMapping("/employee")
    public void removeEmployee(@RequestBody int id){
        System.out.println("id: "+id);
        repository.deleteById(id);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return repository.findAll();
    }


    @PostMapping("/mascota")
    public Mascota addMascota(@RequestBody Mascota mascota){
        System.out.println(mascota.toString());
        System.out.println("--------------INSERT------------");
        return repositorym.save(mascota);
    }
    @GetMapping("/mascotas")
    public List<Mascota> getMascotas(){
        return repositorym.findAll();
    }
    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

}
