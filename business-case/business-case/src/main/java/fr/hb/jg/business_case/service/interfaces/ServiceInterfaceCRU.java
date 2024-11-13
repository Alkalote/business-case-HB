package fr.hb.jg.business_case.service.interfaces;

public interface ServiceInterfaceCRU<T, L, C, U>{

    T create(C o);

    T update(U o, L id);

    T findOneById(L id);
}
