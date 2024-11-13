package fr.hb.jg.business_case.service.interfaces;

import java.util.List;

public interface ServiceListInterfaceCRD<T, L, C> extends ServiceInterfaceCRD<T, L, C>{

    List<?> list();
}
