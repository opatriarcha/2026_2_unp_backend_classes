package br.edu.unp.blog.backend.resources;

import br.edu.unp.blog.backend.datasource.repositories.UserRepository;
import br.edu.unp.blog.backend.domainmodel.entities.User;
import br.edu.unp.blog.backend.resources.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Postapping;
import org.springframework.web.bind.annotation.UpdateMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
//        List<User> users = this.userRepository.findAll();
//        if( users == null || users.isEmpty() )
//            return ResponseEntity.ok(Collections.emptyList());
//        return ResponseEntity.ok(users);
          return ResponseEntity.ok(
                  this.userRepository.findAll()
                          .stream()
                          .map(UserDTO::fromEntity)
                          .collect(Collectors.toList())
          );
    }

    //http://localhost:8080/api/v1/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById( @PathVariable("id") UUID id ){
        return this.userRepository.findById(id)
                .map(user -> ResponseEntity.ok(UserDTO.fromEntity(user)))
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    //HATEOAS
    //http://localhost:8080/api/v1/users
    @PostMapping
    public ResponseEntity<UserDTO> create( @RequestBody @Valid UserDTO user){
        UserDTO savedUser = this.userRepository.save(UserDTO.fromDTO(user));
        Uri location = ServletUriComponentBuilder.fromCurretRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteById( @PathVariable UUID id ){
        if( !this.userRepository.existsById(id) )
            return ResponseEntity.notFound().build();

        this.userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}"
    public ResponseEntity<UserDTO> update( UUID id, @RequestBody UserDto dto ){
        if( !this.userRepository.existsById(id) )
            return ResponseEntity.notFound().build();
        User user = UserDTO.fromDTO(dto);
        user.setId(id);

        UserDTO savedUser = this.userRepository.save(UserDTO.fromDTO(user));
        Uri location = ServletUriComponentBuilder.fromCurretRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    @PatchMapping("{/id}")
    public ResponseEntity<UserDTO> partialUpdate( UUID id, @RequestBody @Valid sUserDto dto, Map<String, Object> values ) {
        return null;
    }

    //http://localhost:8080/api/v1/users/paged
    @GetMapping("/paged" )
    public ResponseEntity<Page<UserDTO>> findAllPaged( @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size,
                                                       @RequestParam(defaultValue = "name") String orderBy,
                                                       @RequestParam(defaultValue = "asc") String direction){
        this.userRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), orderBy)));
    }
}
