package br.edu.unp.blog.backend.resources.dtos;

import br.edu.unp.blog.backend.domainmodel.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.ToString.Exclude;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of= "id")
@ToString
@Getter
public class UserDTO {

    private UUID id;

    @NotBlank(message="O nome é obrigatório")
    @Size(max=60, message="O nome deve ter no máximo 60 caracteres")
    private String name;

    @Size(max=60, min=8, message = "O campo email deve ter entre 8 e 60 posicoes")
    @NotBlank(message="O campo email é obrigatório")
    private String email;

    @Size(max=20, min=8, message="O campo senha deve ter entre 8 e 20 posicoes")
    @NotBlank(message="O campo senha é obrigatório")
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public static UserDTO fromEntity(User user) {
        if( user == null )
            return null;

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User fromDTO(UserDTO user){
        if( user == null )
            return null;

        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
