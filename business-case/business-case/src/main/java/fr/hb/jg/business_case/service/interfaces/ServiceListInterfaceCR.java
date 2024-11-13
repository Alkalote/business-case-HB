package fr.hb.jg.business_case.service.interfaces;

import java.util.List;

public interface ServiceListInterfaceCR <T, L, C> extends ServiceInterfaceCR<T, L, C>{

    List<?> list();

}
