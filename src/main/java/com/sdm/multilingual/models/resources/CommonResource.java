package com.sdm.multilingual.models.resources;

import lombok.Data;

@Data
public abstract class CommonResource<T, M> {

    // * Boxed Class 필수
    protected Integer sequence;
    protected Integer displayOrder;
    protected String displayName;
    protected String desc;
    protected Byte activeFlag;
    protected Byte enableFlag;

    public abstract M toInsert();

    public abstract M toUpdate();

    public abstract T toEntity();

}
