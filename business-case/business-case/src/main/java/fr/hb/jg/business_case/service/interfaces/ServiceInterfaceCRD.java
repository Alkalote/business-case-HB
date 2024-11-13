package fr.hb.jg.business_case.service.interfaces;

public interface ServiceInterfaceCRD<T, L, C>{

    T create(C o);

    T findOneById(L id);

    Boolean delete(L o);

}