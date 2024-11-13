package fr.hb.jg.business_case.service.interfaces;

import java.util.List;

public interface ServiceListInterfaceCRU <T, L, C, U> extends ServiceInterfaceCRU<T, L, C, U>  {

    List<?> list();

}
