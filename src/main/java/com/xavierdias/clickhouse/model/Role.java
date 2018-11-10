package com.xavierdias.clickhouse.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idrole;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Usuario> usuario;

    @ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "idrole"),
    inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "idprivilege"))

    private Collection<Privilege> privileges;

    public Role(){
        super();
    }

    public long getIdrole() {
        return idrole;
    }

    public void setIdrole(long idrole) {
        this.idrole = idrole;
    }

    public Collection<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Collection<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
