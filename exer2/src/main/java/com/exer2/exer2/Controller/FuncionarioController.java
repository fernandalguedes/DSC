package com.exer2.exer2.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exer2.exer2.Model.Funcionario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("exer2")
public class FuncionarioController {
    
    private List<Funcionario> funcionarios = new ArrayList<>();
       
    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> cadastraFuncionario(@RequestBody Funcionario funcionario) {
        funcionarios.add(funcionario);
        return ResponseEntity.ok(funcionario);
    } 
    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable Long id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                return ResponseEntity.ok(funcionario);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/funcionario/{id}/avaliar")
    public ResponseEntity<Funcionario> avaliarFuncionario(
        @PathVariable Long id, @RequestParam int avaliacao, @RequestParam boolean metaAlcancada) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                funcionario.calculaBonus(avaliacao, metaAlcancada);
                return ResponseEntity.ok(funcionario);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/funcionario/{id}/bonus")
    public ResponseEntity<?> bonusFuncionario(@PathVariable Long id) {
        double salarioNovo=0.0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
               salarioNovo= funcionario.getSalario()+ funcionario.getBonus();
                return  ResponseEntity.ok("Novo salario: "+ salarioNovo+ "Bônus: "+funcionario.getBonus());
            }
        }
        return ResponseEntity.notFound().build();
    }

}
