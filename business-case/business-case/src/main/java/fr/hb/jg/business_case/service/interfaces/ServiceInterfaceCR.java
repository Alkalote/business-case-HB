package fr.hb.jg.business_case.service.interfaces;

public interface ServiceInterfaceCR<T, L, C>{

    T create(C o);

    T findOneById(L id);


}
