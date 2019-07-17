package com.mo.dict.models.resources;

import lombok.Data;

@Data
public abstract class CommonResource<T, M> {

    protected static final int INIT_SEQUENCE = 0;

    // TODO to abstract (구체적인 항목이 들어가지 않도록)
    // * Boxed Class 필수
    protected Integer sequence;
    protected Integer displayOrder;
    protected String displayName;
    protected String desc;
    protected Byte activeFlag;
    protected Byte enableFlag;

    public abstract M toInsert() throws Exception;

    public abstract M toUpdate() throws Exception;

    public abstract T toEntity();

}
