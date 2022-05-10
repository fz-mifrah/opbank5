package com.iga.opbank.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.iga.opbank.domain.PaimentFacture} entity.
 */
public class PaimentFactureDTO implements Serializable {

    private Long id;

    @NotNull
    private Long referance;

    private Set<ServiceClassDTO> serviceClasses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReferance() {
        return referance;
    }

    public void setReferance(Long referance) {
        this.referance = referance;
    }

    public Set<ServiceClassDTO> getServiceClasses() {
        return serviceClasses;
    }

    public void setServiceClasses(Set<ServiceClassDTO> serviceClasses) {
        this.serviceClasses = serviceClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaimentFactureDTO)) {
            return false;
        }

        PaimentFactureDTO paimentFactureDTO = (PaimentFactureDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paimentFactureDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaimentFactureDTO{" +
            "id=" + getId() +
            ", referance=" + getReferance() +
            ", serviceClasses=" + getServiceClasses() +
            "}";
    }
}
