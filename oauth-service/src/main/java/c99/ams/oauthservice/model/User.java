package c99.ams.oauthservice.model;

import c99.ams.oauthservice.dto.UserAuthDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/22/2021 3:58 PM
 */
@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public User(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }

    public User(UserAuthDTO userAuthDTO) {
        this.password = userAuthDTO.getPassword();
        this.email = userAuthDTO.getEmail();
        this.roles = new HashSet<>(Arrays.asList(new Role(1L,"ROLE_CUSTOMER")));
    }

    public User() {
    }

    public User(Long id, String password, String email, Set<Role> roles) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
