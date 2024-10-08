package fr.hb.jg.business_case.service.interfaces;

public interface DTOMapperInterface<T, L> {

    T toObject(L dto);

    L toDTO(T object);

}
