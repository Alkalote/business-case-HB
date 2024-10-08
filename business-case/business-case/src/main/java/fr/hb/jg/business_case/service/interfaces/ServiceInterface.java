package fr.hb.jg.business_case.service.interfaces;

public interface ServiceInterface<T, L, C, U> {

    T create(C o);

    T update(U o, L id);

    Boolean delete(L o);

    T findOneById(L id);

}
