package ifsul.edu.br.dsc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class AddressController {

    
    private List<Address> addresses= new ArrayList<>(

            Arrays.asList(
                new Address("38400100", "Floriano Peixoto", "Centro", "Uberlândia"),              
                new Address("38400200", "Tiradentes", "Fundinho", "Uberlândia"), 
                new Address("38400300", "Lions Clube", "Osvaldo Rezende", "Uberlândia")

            )

   
    );
    
    @GetMapping("/hello")
    
    public String helloWorld(@RequestParam(
       
        required = true,
        name="nome"
    ) String nome, 
    String sobrenome) {
        return String.format("Olá Mundo!! %s %s",nome,sobrenome);
    }

    @GetMapping("/address")
    public List<Address> getAddresses() {
        return this.addresses;
    }
    @GetMapping("/address/{cep}")
    public ResponseEntity<Address> getAddress(@PathVariable String cep) {
          
        for(Address address:this.addresses){
            if(address.getCep().equals(cep)){
                return ResponseEntity.ok(address);
            }
        }
        return ResponseEntity.notFound().build();
        
    }
    @PostMapping("/address")
    public void addAddress(@RequestBody Address address) {
        this.addresses.add(address);
     
    }
   
    // @DeleteMapping("/address/delete/{cep}")
    @GetMapping("/address/delete/{cep}")
    public List <Address> deleteAddress(@PathVariable String cep) {
        for(Address address:addresses){
            if(address.getCep().equals(cep)){
                this.addresses.remove(address);
                return addresses;
            }

        }
        return addresses;
    }
 
    
}