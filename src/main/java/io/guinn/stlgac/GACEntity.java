package io.guinn.stlgac;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Objects;

@MappedSuperclass
public abstract class GACEntity extends GACObject {

    @Id
    @GeneratedValue
    protected Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Version
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!o.getClass().equals(this.getClass())) return false;
        GACEntity gacEntity = (GACEntity) o;
        return getId().equals(gacEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
