package com.example.server.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.server.entity.Livres;
import com.example.server.dao.LivresRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController//Indique que cette classe est un contrôleur REST et donc que le format est JSON
public class LivresController {
    private final LivresRepository repo;//final = constante
    public LivresController(LivresRepository pr){
        repo = pr;
    }

    @GetMapping("/api/livrs")//Indique que cette méthode est accessible via une requête GET sur l'URL "/rest/personnes"
    public List<Livres> getLivres() {
        return repo.findAll();
    }
    
    @GetMapping("/api/livres/{id}")
    public Livres getLivre(@PathVariable long id){
        return repo.findById(id).orElse(new Livres("Inconnu", "Inconnu", "Inconnu", "Inconnu"));
    }

    @PutMapping("/api/livres/{id}")
    public Livres updateFruit(@RequestBody Livres newLivre, @PathVariable long id){
        return repo.findById(id)
            .map(livre -> {
                livre.setTitre(newLivre.getTitre());
                livre.setAuteur(newLivre.getAuteur());
                livre.setEdition(newLivre.getEdition());
                livre.setDescription(newLivre.getDescription());
            return repo.save(livre);
            })
            .orElseGet(() -> {
                newLivre.setId(id);
                return repo.save(newLivre);
            });
    }

    @DeleteMapping("/api/livres/{id}")
    public void delPersonne(@PathVariable long id){
        repo.deleteById(id);
    }

}
