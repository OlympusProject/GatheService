package com.zeus.core.domain;

import java.time.LocalDateTime;

/**
 * This class provides persistence capabilities of an Domain.
 * It has mandatory members for saving to DB: createdAt, updatedAt, deletedAt, version
 */
public abstract class PersistenceDomain extends AnyDomain {

    // -- instance variables ------------------------------------------------------------------------------------------
    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    protected LocalDateTime deletedAt;

    protected Long version;



    // -- instance variables ------------------------------------------------------------------------------------------
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
